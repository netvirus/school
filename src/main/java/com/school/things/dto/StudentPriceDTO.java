package com.school.things.dto;

import com.school.things.entities.school.Price;
import com.school.things.entities.student.StudentDiscount;

import java.util.List;

public class StudentPriceDTO {
    private Long id;
    private Price price;
    private List<StudentDiscount> studentDiscounts;
    private Boolean isActive = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public List<StudentDiscount> getStudentDiscounts() {
        return studentDiscounts;
    }

    public void setStudentDiscounts(List<StudentDiscount> studentDiscounts) {
        this.studentDiscounts = studentDiscounts;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
