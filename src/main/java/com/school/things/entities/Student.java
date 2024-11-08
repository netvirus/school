package com.school.things.entities;

import com.school.things.entities.abstracts.Person;
import com.school.things.entities.prices.StudentPersonalPrice;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student extends Person {
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
    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<StudentPersonalPrice> studentPersonalPriceList;

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

    public List<StudentPersonalPrice> getStudentPersonalPriceList() {
        return studentPersonalPriceList;
    }

    public void setStudentPersonalPriceList(List<StudentPersonalPrice> studentPersonalPriceList) {
        this.studentPersonalPriceList = studentPersonalPriceList;
    }
}
