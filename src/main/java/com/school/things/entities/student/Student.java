package com.school.things.entities.student;

import com.school.things.entities.abstracts.Person;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "grade", length = 10, nullable = false)
    private String grade;
    @Column(name = "mother_name", length = 90, nullable = false)
    private String motherName;
    @Column(name = "father_name", length = 90, nullable = false)
    private String fatherName;
    @Column(name = "mother_phone_number", length = 90, nullable = false)
    private String motherPhoneNumber;
    @Column(name = "father_phone_number", length = 90, nullable = false)
    private String fatherPhoneNumber;
    // STUDENT PRICE
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentPrice> studentPrice = new ArrayList<>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentDiscount> studentDiscounts = new ArrayList<>();

    public Student(Long id, String firstName, String lastName, int age, String gender, String nationality, String phoneNumber, String address, Date createdAt, String grade, String motherName, String fatherName, String motherPhoneNumber, String fatherPhoneNumber) {
        super();
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public String getFatherPhoneNumber() {
        return fatherPhoneNumber;
    }

    public void setFatherPhoneNumber(String fatherPhoneNumber) {
        this.fatherPhoneNumber = fatherPhoneNumber;
    }

    public List<StudentPrice> getStudentPrice() {
        return studentPrice;
    }

    public void setStudentPrice(List<StudentPrice> studentPrice) {
        this.studentPrice = studentPrice;
    }

    public List<StudentDiscount> getStudentDiscounts() {
        return studentDiscounts;
    }

    public void setStudentDiscounts(List<StudentDiscount> studentDiscounts) {
        this.studentDiscounts = studentDiscounts;
    }
}
