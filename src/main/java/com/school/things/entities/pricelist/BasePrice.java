package com.school.things.entities.pricelist;

import jakarta.persistence.*;

@Entity
@Table(name = "base_price")
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

    // Конструктор по умолчанию (требуется для JPA)
    public BasePrice() {
    }

    // Конструктор с параметрами для удобства инициализации
    public BasePrice(Long id, Long paymentItemId, Double paymentItemPrice, Integer priceYear, String paymentItemName, String gradeName) {
        this.id = id;
        this.paymentItemId = paymentItemId;
        this.paymentItemPrice = paymentItemPrice != null ? paymentItemPrice : 0.0;
        this.priceYear = priceYear != null ? priceYear : 0;
        this.paymentItemName = paymentItemName;
        this.gradeName = gradeName;
    }

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
