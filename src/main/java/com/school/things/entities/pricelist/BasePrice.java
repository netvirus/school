package com.school.things.entities.pricelist;

import com.school.things.entities.Grade;
import jakarta.persistence.*;

@Entity
@Table(name = "base_price")
public class BasePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Оставить если необходима ленивость
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY) // Оставить если необходима ленивость
    @JoinColumn(name = "payment_item_id")
    private PaymentItem paymentItem;

    private int priceYear;
    private double paymentItemPrice;

    // Конструктор по умолчанию для JPA
    public BasePrice() {
    }

    public Long getId() {
        return id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public PaymentItem getPaymentItem() {
        return paymentItem;
    }

    public void setPaymentItem(PaymentItem paymentItem) {
        this.paymentItem = paymentItem;
    }

    public int getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
    }

    public double getPaymentItemPrice() {
        return paymentItemPrice;
    }

    public void setPaymentItemPrice(double paymentItemPrice) {
        this.paymentItemPrice = paymentItemPrice;
    }
}
