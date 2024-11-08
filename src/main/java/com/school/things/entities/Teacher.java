package com.school.things.entities;

import com.school.things.entities.abstracts.Person;
import jakarta.persistence.*;

@Entity
public class Teacher extends Person {
    @Column(name = "subject", length = 100, nullable = false)
    private String subject;
    @Column(name = "grade", length = 10, nullable = false)
    private String grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
