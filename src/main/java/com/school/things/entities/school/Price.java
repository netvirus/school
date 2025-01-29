package com.school.things.entities.school;

import com.school.things.entities.student.Student;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 200, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
