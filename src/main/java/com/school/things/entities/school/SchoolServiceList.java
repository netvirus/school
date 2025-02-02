package com.school.things.entities.school;

import jakarta.persistence.*;

@Entity
@Table(name = "school_services_list")
public class SchoolServiceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "service_name", nullable = false)
    private String serviceName;

    public SchoolServiceList() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

//    @OneToMany(mappedBy = "price_services_list_id")
//    private List<PriceServicesList> priceServicesList = new ArrayList<>();
}
