package com.school.things.entities.pricelist;

import jakarta.persistence.*;

@Entity
@Table(name = "prices", uniqueConstraints = @UniqueConstraint(columnNames = "price_year"))
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_year", nullable = false)
    private int priceYear;

    @Column(name = "description")
    private String description;

    public Prices() {}

    public Prices(int priceYear, String description) {
        this.priceYear = priceYear;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(int priceYear) {
        this.priceYear = priceYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
