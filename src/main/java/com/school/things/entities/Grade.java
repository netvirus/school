package com.school.things.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.things.entities.student.StudentPrice;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    List<StudentPrice> studentPrice;

    public Grade() {}
}
