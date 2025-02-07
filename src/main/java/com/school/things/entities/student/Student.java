package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.abstracts.Person;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "grade", length = 10, nullable = false)
    private String grade;
    @Column(name = "mother_name", length = 90, nullable = false)
    private String motherName;
    @Column(name = "father_name", length = 90, nullable = false)
    private String fatherName;
    @Column(name = "mother_phone_number", length = 90, nullable = false)
    private String motherPhoneNumber;
    @Column(name = "father_phone_number", length = 90, nullable = false)
    private String fatherPhoneNumber;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StudentPrice> studentPrices = new ArrayList<>();

    public Student() { }
}
