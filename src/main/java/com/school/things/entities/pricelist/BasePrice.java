package com.school.things.entities.pricelist;

import jakarta.persistence.*;

@Entity
@Table(name = "academic_year_base_price")
public class BasePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gradeId;
    private int priceYear;
    private Long paymentItemId;
    private double paymentItemPrice;
    @Transient // Это поле не будет сохранено в базу данных
    private String paymentItemName;

    @Transient // Это поле не будет сохранено в базу данных
    private String gradeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public int getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
    }

    public Long getPaymentItemId() {
        return paymentItemId;
    }

    public void setPaymentItemId(Long paymentItemId) {
        this.paymentItemId = paymentItemId;
    }

    public double getPaymentItemPrice() {
        return paymentItemPrice;
    }

    public void setPaymentItemPrice(double paymentItemPrice) {
        this.paymentItemPrice = paymentItemPrice;
    }

    public String getPaymentItemName() {
        return paymentItemName;
    }

    public void setPaymentItemName(String paymentItemName) {
        this.paymentItemName = paymentItemName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}

