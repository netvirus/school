package com.school.things.requests;

import java.util.List;

public class ExpenseReceiptRequest {

    private Long storekeeperId;
    private Long studentId;
    private List<ExpenseReceiptItemRequest> items;

    public Long getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(Long storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public List<ExpenseReceiptItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ExpenseReceiptItemRequest> items) {
        this.items = items;
    }
}
