package com.school.things.entities.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    @JoinColumn(name = "price_id")
    @JsonManagedReference
    private List<PriceServicesList> priceServicesList;

    public List<PriceServicesList> getPriceServicesList() {
        return priceServicesList;
    }

    public void setPriceServicesList(List<PriceServicesList> priceServicesList) {
        this.priceServicesList = priceServicesList;
    }
}
