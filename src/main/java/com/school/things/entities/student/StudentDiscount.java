package com.school.things.entities.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student_discount")
public class StudentDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "personal_price_id", nullable = false)
    private Long personalPriceId;
    @Column(name = "school_service_id", nullable = false)
    private Long schoolServiceId;
    @Column(name = "cost", nullable = true)
    private Long schoolServiceCost;
    @Column(name = "discount", nullable = false)
    private int discount = 0;

    public StudentDiscount() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonalPriceId() {
        return personalPriceId;
    }

    public void setPersonalPriceId(Long personalPriceId) {
        this.personalPriceId = personalPriceId;
    }

    public Long getSchoolServiceId() {
        return schoolServiceId;
    }

    public void setSchoolServiceId(Long schoolServiceId) {
        this.schoolServiceId = schoolServiceId;
    }

    public Long getSchoolServiceCost() {
        return schoolServiceCost;
    }

    public void setSchoolServiceCost(Long schoolServiceCost) {
        this.schoolServiceCost = schoolServiceCost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
