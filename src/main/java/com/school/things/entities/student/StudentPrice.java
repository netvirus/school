package com.school.things.entities.student;

import com.school.things.entities.school.Price;
import jakarta.persistence.*;

@Entity
@Table(name = "student_price")
public class StudentPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    // STUDENT
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    // PRICE
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_discount_id")
    private StudentDiscount studentDiscount;

    public StudentPrice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public StudentDiscount getStudentDiscount() {
        return studentDiscount;
    }

    public void setStudentDiscount(StudentDiscount studentDiscount) {
        this.studentDiscount = studentDiscount;
    }

    @Override
    public String toString() {
        return "StudentPrice{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", student=" + student +
                ", price=" + price +
                ", studentDiscount=" + studentDiscount +
                '}';
    }
}
