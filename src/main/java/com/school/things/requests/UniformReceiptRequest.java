package com.school.things.requests;

import java.util.List;

public class UniformReceiptRequest {

    private List<UniformItemRequest> items;

    // Геттеры и сеттеры

    public List<UniformItemRequest> getItems() {
        return items;
    }

    public void setItems(List<UniformItemRequest> items) {
        this.items = items;
    }
}
