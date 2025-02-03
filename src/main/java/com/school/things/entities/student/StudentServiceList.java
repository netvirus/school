package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.school.PriceServiceList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "student_services_list")
public class StudentServiceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "discount", nullable = false)
    private double discount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_service_list_id")
    @JsonManagedReference
    private PriceServiceList priceServiceList;

    public StudentServiceList() {
    }
}
