package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.payment.PaymentCurrency;
import com.school.things.entities.price.Price;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_price")
public class StudentPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_period", nullable = false)
    private int paymentPeriod;
    @Column(name = "is_active", nullable = false)
    private Boolean active = false;

    /**
     *  Back to PriceServiceList
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    /**
     *  Connect to Grade
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    /**
     *  Connect to StudentServiceDiscountList
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_service_discount_list_id")
    @JsonManagedReference
    private List<StudentServiceDiscountList> studentServiceDiscountList;

    /**
     *  Connect to PaymentCurrency
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_currency_id")
    @JsonManagedReference
    private PaymentCurrency paymentCurrency;

    /**
     *  Connect to StudentPayment
     */
    @OneToMany(mappedBy = "studentPrice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentPayment> payments = new ArrayList<>();

    public StudentPrice() {}
}
