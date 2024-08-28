package com.school.things.requests;

public class GeneralReceiptItemRequest {

    private Long itemId;     // ID предмета (Books, Pants, Skirt, Shirt, Shorts)
    private String itemType; // Тип предмета ("books", "pants", "skirt", "shirt", "shorts")
    private int quantity;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
