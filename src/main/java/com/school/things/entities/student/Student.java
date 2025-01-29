package com.school.things.entities.student;

import com.school.things.entities.abstracts.Person;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long student_id;
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
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private List<StudentPrice> studentPrice;

    public Student(Long student_id, String firstName, String lastName, int age, String gender, String nationality, String phoneNumber, String address, Date createdAt, String grade, String motherName, String fatherName, String motherPhoneNumber, String fatherPhoneNumber) {
        super();
    }

    public Student() {

    }
    public Long getId() {
        return student_id;
    }

    public void setId(Long student_id) {
        this.student_id = student_id;
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
}
