
package com.example.quickrelief;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final RequestRepository requestRepository;

    public SupplyService(
            SupplyRepository supplyRepository,
            RequestRepository requestRepository
    ) {
        this.supplyRepository = supplyRepository;
        this.requestRepository = requestRepository;
    }

    // Add new supplies or restock existing supplies
    @Transactional
    public Supply addOrRestock(SupplyInput input) {

        if (input.itemName() == null
                || input.itemName().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Item name is required"
            );
        }

        if (input.quantity() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Quantity must be greater than zero"
            );
        }

        String itemName = input.itemName().trim();

        Supply existing =
                supplyRepository.findByItemName(itemName);

        if (existing == null) {
            supplyRepository.insert(itemName, input.quantity());
        } else {
            int newQuantity =
                    existing.getQuantity() + input.quantity();

            supplyRepository.updateQuantity(
                    itemName, newQuantity
            );
        }

        return supplyRepository.findByItemName(itemName);
    }

    // Return the complete inventory
    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    // Allocate supplies and record the request
    @Transactional
    public SupplyRequest allocate(AllocationInput input) {

        if (input.itemName() == null
                || input.itemName().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Item name is required"
            );
        }

        if (input.requestedBy() == null
                || input.requestedBy().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Requested by is required"
            );
        }

        if (input.quantity() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Quantity must be greater than zero"
            );
        }

        String itemName = input.itemName().trim();

        // Find and lock the inventory row
        Supply supply =
                supplyRepository.findByItemNameForUpdate(itemName);

        if (supply == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Supply item not found"
            );
        }

        if (supply.getQuantity() < input.quantity()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Insufficient stock. Available quantity: "
                            + supply.getQuantity()
            );
        }

        int updatedRows = supplyRepository.deductQuantity(
                itemName, input.quantity()
        );

        if (updatedRows != 1) {
            throw new IllegalStateException(
                    "Inventory update failed"
            );
        }

        return requestRepository.save(
                itemName,
                input.quantity(),
                "APPROVED",
                input.requestedBy().trim()
        );
    }
}
