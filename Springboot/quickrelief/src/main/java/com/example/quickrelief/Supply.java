
package com.example.quickrelief;

public class Supply {

    private final long id;
    private final String itemName;
    private final int quantity;

    public Supply(long id, String itemName, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
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
}
