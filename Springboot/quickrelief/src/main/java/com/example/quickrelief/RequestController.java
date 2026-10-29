
package com.example.quickrelief;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final SupplyService supplyService;

    public RequestController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    // Original POST endpoint
    @PostMapping
    public SupplyRequest createRequest(@RequestBody AllocationInput input) {
        return supplyService.allocate(input);
    }

    // Temporary GET endpoint for browser testing
    @GetMapping("/allocate")
    public SupplyRequest allocateUsingUrl(
            @RequestParam String itemName,
            @RequestParam int quantity,
            @RequestParam String requestedBy) {

        return supplyService.allocate(
                new AllocationInput(itemName, quantity, requestedBy)
        );
    }
}
