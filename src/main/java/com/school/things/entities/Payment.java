package com.school.things.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    @NotNull(message = "Payer ID cannot be null")
    private Long payerId;

    @Min(value = 1, message = "Month should be between 1 and 12")
    @Max(value = 12, message = "Month should be between 1 and 12")
    private int numberOfMonth;
    private double discount;

    @JsonFormat(pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime paymentDate;

    public Payment() {}

    public Payment(double amount, Long payerId, int numberOfMonth, double discount, LocalDateTime paymentDate) {
        this.amount = amount;
        this.payerId = payerId;
        this.numberOfMonth = numberOfMonth;
        this.discount = discount;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public int getNumberOfMonth() {
        return numberOfMonth;
    }

    public void setNumberOfMonth(int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", payerId=" + payerId +
                ", numberOfMonth=" + numberOfMonth +
                ", discount=" + discount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
