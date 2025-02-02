package com.school.things.entities.school;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceList;
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

    // BACK TO - StudentPrice
    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<StudentPrice> studentPrices;

    // TO - PriceServicesList
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_service_list_id")
    @JsonManagedReference
    private List<PriceServiceList> priceServiceList;

    // TO - PriceServicesList
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_service_list_id")
    @JsonManagedReference
    private List<StudentServiceList> studentServiceLists;

    public List<StudentPrice> getStudentPrices() {
        return studentPrices;
    }

    public void setStudentPrices(List<StudentPrice> studentPrices) {
        this.studentPrices = studentPrices;
    }

    public List<PriceServiceList> getPriceServiceList() {
        return priceServiceList;
    }

    public void setPriceServiceList(List<PriceServiceList> priceServiceList) {
        this.priceServiceList = priceServiceList;
    }

    public List<StudentServiceList> getStudentServiceLists() {
        return studentServiceLists;
    }

    public void setStudentServiceLists(List<StudentServiceList> studentServiceLists) {
        this.studentServiceLists = studentServiceLists;
    }
}
