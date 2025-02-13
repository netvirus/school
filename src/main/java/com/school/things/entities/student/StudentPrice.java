package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.price.Price;
import jakarta.persistence.*;
import lombok.*;

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

//    /**
//     *  Connect to Price
//     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "price_id")
//    @JsonManagedReference
//    private Price price;

    /**
     *  Connect to StudentServiceDiscountList
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_service_discount_list_id")
    @JsonManagedReference
    private List<StudentServiceDiscountList> studentServiceDiscountList;

    public StudentPrice() {}
}
