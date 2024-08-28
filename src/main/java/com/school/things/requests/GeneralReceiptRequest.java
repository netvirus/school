package com.school.things.requests;

import java.util.List;

public class GeneralReceiptRequest {

    private Long storekeeperId;
    private List<GeneralReceiptItemRequest> items;

    public Long getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(Long storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public List<GeneralReceiptItemRequest> getItems() {
        return items;
    }

    public void setItems(List<GeneralReceiptItemRequest> items) {
        this.items = items;
    }
}
