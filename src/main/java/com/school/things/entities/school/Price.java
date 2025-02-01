package com.school.things.entities.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "student_price_id", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StudentPrice> studentPrices;

    @OneToMany
    @JoinColumn(name = "price_id")
    @JsonManagedReference
    private List<PriceServicesList> priceServicesList;

    public List<PriceServicesList> getPriceServicesList() {
        return priceServicesList;
    }

    public void setPriceServicesList(List<PriceServicesList> priceServicesList) {
        this.priceServicesList = priceServicesList;
    }

    public List<StudentPrice> getStudentPrices() {
        return studentPrices;
    }

    public void setStudentPrices(List<StudentPrice> studentPrices) {
        this.studentPrices = studentPrices;
    }
}
