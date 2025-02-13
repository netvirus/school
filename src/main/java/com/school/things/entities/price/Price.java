package com.school.things.entities.price;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.payment.PaymentPeriod;
import com.school.things.entities.student.Grade;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceDiscountList;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    /**
     *  Back to StudentPrice
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<StudentPrice> studentPrices;

    /**
     *  Connect to PriceServiceList
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_service_list_id")
    @JsonManagedReference
    private List<PriceServiceList> priceServiceList;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_service_list_id")
//    @JsonManagedReference
//    private List<StudentServiceDiscountList> studentServiceDiscountLists;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "payment_period_id")
//    private PaymentPeriod paymentPeriod;

    /**
     *  Back to Grade
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "grade_id")
    private List<Grade> grade;

    public Price() {
    }
}
