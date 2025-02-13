package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.price.Price;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    /**
     *  Back to StudentPrice
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    List<StudentPrice> studentPrice;

    /**
     *  Connect to Price
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonManagedReference
    private Price price;

    public Grade() {}
}
