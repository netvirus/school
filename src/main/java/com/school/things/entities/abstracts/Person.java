package com.school.things.entities.abstracts;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
public abstract class Person {
    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;
    @Column(name = "age", length = 3, nullable = false)
    private int age;
    @Column(name = "gender", length = 10, nullable = false)
    private String gender;
    @Column(name = "nationality", length = 50, nullable = false)
    private String nationality;
    @Column(name = "phone_number", length = 50, nullable = true)
    private String phoneNumber;
    @Column(name = "address", length = 200, nullable = false)
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    public Person() {

    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
