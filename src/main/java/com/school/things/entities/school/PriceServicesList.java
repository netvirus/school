package com.school.things.entities.school;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "price_services_list")
public class PriceServicesList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost", nullable = true)
    private Long serviceCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonBackReference
    private Price price;

    public PriceServicesList() {}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_services_list_id")
    private SchoolServicesList schoolServicesList =  new SchoolServicesList();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getServiceCost() {
        return serviceCost;
    }
    public void setServiceCost(Long serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public SchoolServicesList getSchoolServicesList() {
        return schoolServicesList;
    }

    public void setSchoolServicesList(SchoolServicesList schoolServicesList) {
        this.schoolServicesList = schoolServicesList;
    }
}
