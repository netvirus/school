package com.school.things.entities.finance;

import io.hypersistence.utils.hibernate.type.array.IntArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Arrays;

@Entity
public class PersonalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gradeId;
    private Long studentId;

    @Type(IntArrayType.class)
    @Column(
            name = "payment_status",
            columnDefinition = "integer[]"
    )
    private int[] paymentStatus = new int[12];

    public PersonalReport() {
        // Инициализация всех месяцев как "не оплачено" (0)
        Arrays.fill(this.paymentStatus, 0);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public int[] getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int[] paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Метод для обновления статуса оплаты за конкретный месяц
    public void setPaymentForMonth(int month, int status) {
        if (month >= 0 && month < 12) {
            this.paymentStatus[month] = status;
        } else {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }
}
