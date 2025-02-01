package com.school.things.entities.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.things.entities.school.SchoolServicesList;
import jakarta.persistence.*;

@Entity
@Table(name = "student_discount")
public class StudentDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "discount", nullable = false)
    private int discount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_price_id")
    @JsonBackReference
    private StudentPrice studentPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_services_id")
    private SchoolServicesList schoolServicesList;

    public StudentDiscount() {
    }

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setStudentPrice(StudentPrice studentPrice) {
        this.studentPrice = studentPrice;
    }

    public StudentPrice getStudentPrice() {
        return studentPrice;
    }

    public SchoolServicesList getSchoolServicesList() {
        return schoolServicesList;
    }

    public void setSchoolServicesList(SchoolServicesList schoolServicesList) {
        this.schoolServicesList = schoolServicesList;
    }
}
