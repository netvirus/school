package com.school.things.entities.payment;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payment_schedule")
public class PaymentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment paymentId;

    @Column(name = "student_price_id", nullable = false)
    private Long studentPriceId;

    @Column(name = "price_id", nullable = false)
    private Long priceId;

    public PaymentSchedule() {
    }
}
