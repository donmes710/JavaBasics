
package com.example.quickrelief;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    public Supply addSupply(@RequestBody SupplyInput input) {
        return supplyService.addOrRestock(input);
    }

    @GetMapping
    public List<Supply> getAllSupplies() {
        return supplyService.getAllSupplies();
    }

    @GetMapping("/add")
    public Supply addSupplyUsingUrl(
            @RequestParam String itemName,
            @RequestParam int quantity
    ) {
        return supplyService.addOrRestock(
                new SupplyInput(itemName, quantity)
        );
    }
}
