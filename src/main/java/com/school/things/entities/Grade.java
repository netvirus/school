package com.school.things.entities;

import com.school.things.entities.pricelist.BasePrice;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Связь One-to-Many с BasePrice
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BasePrice> basePrices;

    // Конструкторы
    public Grade() {}

    public Grade(String name) {
        this.name = name;
    }

    // Геттеры и сеттеры

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

    public List<BasePrice> getBasePrices() {
        return basePrices;
    }

    public void setBasePrices(List<BasePrice> basePrices) {
        this.basePrices = basePrices;
    }
}
