package com.school.things.entities.pricelist;

import jakarta.persistence.*;

@Entity
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String priceYear;
    private String priceDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriceYear() {
        return priceYear;
    }

    public void setPriceYear(String priceYear) {
        this.priceYear = priceYear;
    }

    public String getPriceDescription() {
        return priceDescription;
    }

    public void setPriceDescription(String priceDescription) {
        this.priceDescription = priceDescription;
    }
}
