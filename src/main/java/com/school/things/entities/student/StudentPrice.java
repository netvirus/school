package com.school.things.entities.student;

import com.school.things.entities.school.Price;
import jakarta.persistence.*;

@Entity
@Table(name = "student_price")
public class StudentPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_price_id")
    private Long student_price_id;
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    @Column(name = "price_id", nullable = false)
    private String priceId;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_price_id")
    private Price price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_owner_id")
    private StudentDiscount studentDiscount;

    public StudentPrice() {}

    public Long getId() {
        return student_price_id;
    }

    public void setId(Long student_price_id) {
        this.student_price_id = student_price_id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
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
                "student_price_id=" + student_price_id +
                ", ownerId=" + ownerId +
                ", priceId='" + priceId + '\'' +
                ", isActive=" + isActive +
                ", student=" + student +
                ", price=" + price +
                ", studentDiscount=" + studentDiscount +
                '}';
    }
}
