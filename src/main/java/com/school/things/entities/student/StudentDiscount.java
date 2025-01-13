package com.school.things.entities.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student_discount")
public class StudentDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Column(name = "price_id", nullable = false)
    private Long priceId;
    @Column(name = "service_id", nullable = false)
    private Long serviceId;
    @Column(name = "discount", nullable = false)
    private int discount = 0;

    public StudentDiscount() {
    }

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getPriceId() {
        return priceId;
    }
    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
    public Long getServiceId() {
        return serviceId;
    }
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @Override
    public String toString() {
        return "StudentDiscount{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", priceId=" + priceId +
                ", serviceId=" + serviceId +
                ", discount=" + discount +
                '}';
    }
}
