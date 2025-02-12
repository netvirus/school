package com.school.things.entities.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.things.entities.price.Price;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "payment_period")
@NoArgsConstructor
public class PaymentPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    private PaymentCurrency currency;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY)
    private List<Price> price;
}
