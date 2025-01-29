package com.school.things.entities.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student_discount")
public class StudentDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_discount_id")
    private Long student_discount_id;
    @Column(name = "student_owner_id", nullable = false)
    private Long studentId;
    @Column(name = "price_id", nullable = false)
    private Long priceId;
    @Column(name = "service_id", nullable = false)
    private Long serviceId;
    @Column(name = "discount", nullable = false)
    private int discount = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_price_id")
    private StudentPrice studentPrice;

    public StudentDiscount() {
    }

    public Long getId() { return student_discount_id; }
    public void setId(Long student_discount_id) {
        this.student_discount_id = student_discount_id;
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

    public StudentPrice getStudentPrice() {
        return studentPrice;
    }

    public void setStudentPrice(StudentPrice studentPrice) {
        this.studentPrice = studentPrice;
    }

    @Override
    public String toString() {
        return "StudentDiscount{" +
                "student_discount_id=" + student_discount_id +
                ", studentId=" + studentId +
                ", priceId=" + priceId +
                ", serviceId=" + serviceId +
                ", discount=" + discount +
                ", studentPrice=" + studentPrice +
                '}';
    }
}
