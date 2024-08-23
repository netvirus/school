package com.school.things.entities.abstracts;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
public abstract class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;  // Пол
    private String nationality;  // Национальность
    private String phoneNumber;  // Телефон
    private String address;  // Адрес проживания

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(createdAt);
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    // Общие методы, которые могут использоваться всеми подклассами
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
