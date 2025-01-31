package com.school.things.dto;

import com.school.things.entities.school.Price;
import com.school.things.entities.student.StudentDiscount;

public class StudentPriceDTO {
    private Long id;
    private Long studentId;
    private Long priceId;
    private Long discountId;
    private Boolean isActive = false;

    public StudentPriceDTO(Long id, Price price, StudentDiscount studentDiscount) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
