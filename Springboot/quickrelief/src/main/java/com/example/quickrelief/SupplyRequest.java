
package com.example.quickrelief;

public class SupplyRequest {

    private final long id;
    private final String itemName;
    private final int quantity;
    private final String status;
    private final String requestedBy;

    public SupplyRequest(
            long id,
            String itemName,
            int quantity,
            String status,
            String requestedBy
    ) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = status;
        this.requestedBy = requestedBy;
    }

    public long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getRequestedBy() {
        return requestedBy;
    }
}
