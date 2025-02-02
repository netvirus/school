package com.school.things.entities.school;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.things.entities.student.StudentServiceList;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "price_service_list")
public class PriceServiceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost", nullable = true)
    private Long cost;

    // BACK TO - Price
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;

    // TO - SchoolServiceList
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_service_list_id")
    SchoolServiceList schoolServiceList;

    @OneToMany(mappedBy = "priceServiceList", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<StudentServiceList> studentServiceList;

    public PriceServiceList() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public SchoolServiceList getSchoolServiceList() {
        return schoolServiceList;
    }

    public void setSchoolServiceList(SchoolServiceList schoolServiceList) {
        this.schoolServiceList = schoolServiceList;
    }

    public List<StudentServiceList> getStudentServiceList() {
        return studentServiceList;
    }

    public void setStudentServiceList(List<StudentServiceList> studentServiceList) {
        this.studentServiceList = studentServiceList;
    }
}
