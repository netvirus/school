package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.price.PriceServiceList;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "student_service_dicount_list")
public class StudentServiceDiscountList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "discount", nullable = false)
    private double discount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_service_list_id")
    @JsonManagedReference
    private PriceServiceList priceServiceList;

    public StudentServiceDiscountList() {
    }

    public double getCostWithDiscount() {
        double cost = priceServiceList.getCost();
        return cost - (cost * discount / 100);
    }
}
