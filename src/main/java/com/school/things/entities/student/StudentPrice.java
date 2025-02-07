package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.price.Price;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonManagedReference
    private Price price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public StudentPrice() {}
}
