package com.school.things.entities.price;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceList;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<StudentPrice> studentPrices;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_service_list_id")
    @JsonManagedReference
    private List<PriceServiceList> priceServiceList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_service_list_id")
    @JsonManagedReference
    private List<StudentServiceList> studentServiceLists;

    public Price() {
    }
}
