package com.school.things.entities.pricelist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.things.entities.Grade;
import jakarta.persistence.*;

@Entity
@Table(name = "base_price")
public class BasePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Связь One-to-One с Prices
    @OneToOne(mappedBy = "basePrice", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Prices prices;

    @ManyToOne
    @JoinColumn(name = "payment_item_id", nullable = false)
    private PaymentItem paymentItem;

    @ManyToOne
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @Column(name = "payment_item_price", nullable = false)
    private double paymentItemPrice;

    // Конструкторы, геттеры и сеттеры
    public BasePrice() {}

    public BasePrice(Prices prices, PaymentItem paymentItem, Grade grade, double paymentItemPrice) {
        this.prices = prices;
        this.paymentItem = paymentItem;
        this.grade = grade;
        this.paymentItemPrice = paymentItemPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public PaymentItem getPaymentItem() {
        return paymentItem;
    }

    public void setPaymentItem(PaymentItem paymentItem) {
        this.paymentItem = paymentItem;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public double getPaymentItemPrice() {
        return paymentItemPrice;
    }

    public void setPaymentItemPrice(double paymentItemPrice) {
        this.paymentItemPrice = paymentItemPrice;
    }
}
