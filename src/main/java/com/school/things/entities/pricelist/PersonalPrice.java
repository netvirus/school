package com.school.things.entities.pricelist;

import io.hypersistence.utils.hibernate.type.array.IntArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Arrays;

@Entity
public class PersonalPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int academicYear;
    private int gradeId;
    private Long studentId;
    @Type(IntArrayType.class)
    @Column(name = "payment_months", columnDefinition = "integer[]")
    private int[] paymentMonths = new int[12];
    @Type(IntArrayType.class)
    @Column(name = "discount_in_months", columnDefinition = "integer[]")
    private int[] discountInMonths = new int[12];
    private Long academicBasePriceId;

    public PersonalPrice() {
        Arrays.fill(this.paymentMonths, 0);
        Arrays.fill(this.discountInMonths, 0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public int[] getPaymentMonths() {
        return paymentMonths;
    }

    public void setPaymentMonths(int[] paymentMonths) {
        this.paymentMonths = paymentMonths;
    }

    public int[] getDiscountInMonths() {
        return discountInMonths;
    }

    public void setDiscountInMonths(int[] discountInMonths) {
        this.discountInMonths = discountInMonths;
    }

    public Long getAcademicBasePriceId() {
        return academicBasePriceId;
    }

    public void setAcademicBasePriceId(Long academicBasePriceId) {
        this.academicBasePriceId = academicBasePriceId;
    }
}
