package com.school.things.entities.student;

import com.school.things.entities.payment.Payment;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToMany(mappedBy = "studentPayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;
}
