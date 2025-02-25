package com.school.things.entities.student;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_payments")
public class StudentPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_price_id", nullable = false)
    private StudentPrice studentPrice;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "paid", nullable = false)
    private boolean paid;

    @Column(name = "amount_paid", nullable = false)
    private double amountPaid;
}
