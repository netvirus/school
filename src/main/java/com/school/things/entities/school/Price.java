package com.school.things.entities.school;

import com.school.things.entities.student.StudentPrice;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name = "price_id")
    private List<PriceServicesList> priceServicesList;

    @OneToMany
    @JoinColumn(name = "student_price_id")
    private List<StudentPrice> studentPrice;

    public List<StudentPrice> getStudentPrices() {
        return studentPrice;
    }

    public void setStudentPrices(List<StudentPrice> studentPrice) {
        this.studentPrice = studentPrice;
    }
}
