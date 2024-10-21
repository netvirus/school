package com.school.things.entities.pricelist;

import com.school.things.entities.Grade;
import jakarta.persistence.*;

@Entity
@Table(name = "base_price")
public class BasePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int priceYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prices_id")
    private Prices prices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_item_id", nullable = false)
    private PaymentItem paymentItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", nullable = false)
    private Grade grade;

    @Column(name = "payment_item_price", nullable = false)
    private double paymentItemPrice;

    public BasePrice() {}

    public BasePrice(PaymentItem paymentItem, Grade grade, double paymentItemPrice, Prices prices) {
        this.paymentItem = paymentItem;
        this.grade = grade;
        this.paymentItemPrice = paymentItemPrice;
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
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

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }
}
