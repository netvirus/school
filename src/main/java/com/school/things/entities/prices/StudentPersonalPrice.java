package com.school.things.entities.prices;

import com.school.things.entities.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "personal_price")
public class StudentPersonalPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;
    @Column(name = "name", nullable = false)
    private String priceName;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
    @ManyToOne(optional = false)
    private Student student;

    public StudentPersonalPrice() {}

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

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
