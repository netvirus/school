package com.school.things.entities.student;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_price")
public class StudentPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    @Column(name = "price_id", nullable = false)
    private String priceId;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<StudentDiscount> studentDiscounts;

    public StudentPrice() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public List<StudentDiscount> getStudentDiscounts() {
        return studentDiscounts;
    }

    public void setStudentDiscounts(List<StudentDiscount> studentDiscounts) {
        this.studentDiscounts = studentDiscounts;
    }

    @Override
    public String toString() {
        return "StudentPrice{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", priceId='" + priceId + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
