package com.school.things.entities.price;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.things.entities.school.SchoolServiceList;
import com.school.things.entities.student.StudentServiceDiscountList;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "price_service_list")
public class PriceServiceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost", nullable = true)
    private double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_service_list_id")
    SchoolServiceList schoolServiceList;

    @OneToMany(mappedBy = "priceServiceList", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<StudentServiceDiscountList> studentServiceDiscountList;

    public PriceServiceList() {
    }
}
