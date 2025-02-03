package com.school.things.entities.school;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.things.entities.student.StudentServiceList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
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
    private List<StudentServiceList> studentServiceList;

    public PriceServiceList() {
    }
}
