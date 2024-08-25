package com.school.things.requests;

public class UniformItemRequest {

    private Long uniformId;
    private String name;
    private String color;
    private int size;
    private int quantity;

    public Long getUniformId() {
        return uniformId;
    }

    public void setUniformId(Long uniformId) {
        this.uniformId = uniformId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
