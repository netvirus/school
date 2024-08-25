package com.school.things.requests;

import java.util.List;

public class BookReceiptRequest {

    private List<BookItemRequest> items;


    public List<BookItemRequest> getItems() {
        return items;
    }

    public void setItems(List<BookItemRequest> items) {
        this.items = items;
    }
}

