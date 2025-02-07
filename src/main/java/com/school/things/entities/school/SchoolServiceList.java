package com.school.things.entities.school;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "school_services_list")
public class SchoolServiceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "service_name", nullable = false)
    private String serviceName;

    public SchoolServiceList() {}
}
