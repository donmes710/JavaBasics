
package com.example.quickrelief;

public record AllocationInput(
        String itemName,
        int quantity,
        String requestedBy
) {
}
