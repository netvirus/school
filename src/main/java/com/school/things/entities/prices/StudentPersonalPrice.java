package com.school.things.entities.prices;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_price")
public class StudentPersonalPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "owner_id", nullable = false)
    private int ownerId;
    @Column(name = "name", nullable = false)
    private String priceName;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public StudentPersonalPrice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
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
}
