package com.school.things.entities.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student_extra_services_list")
public class StudentExtraServicesList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price_id", nullable = false)
    private Long priceId;
    @Column(name = "school_service_id", nullable = false)
    private Long schoolServiceId;
    @Column(name = "cost", nullable = true)
    private Long serviceCost;
    public StudentExtraServicesList() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPriceId() {
        return priceId;
    }
    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }
    public Long getSchoolServiceId() {
        return schoolServiceId;
    }
    public void setSchoolServiceId(Long schoolServiceId) {
        this.schoolServiceId = schoolServiceId;
    }
    public Long getServiceCost() {
        return serviceCost;
    }
    public void setServiceCost(Long serviceCost) {
        this.serviceCost = serviceCost;
    }
}
