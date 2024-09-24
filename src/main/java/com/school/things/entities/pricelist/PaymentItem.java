package com.school.things.entities.pricelist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment_item")
public class PaymentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Связь One-to-Many с BasePrice
    @OneToMany(mappedBy = "paymentItem", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BasePrice> basePrices;

    // Конструкторы
    public PaymentItem() {}

    public PaymentItem(String name) {
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
