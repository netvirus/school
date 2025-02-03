package com.school.things.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class StudentServiceListDTO {
    private Long id;
    private int discount;
    private String serviceName;
    private int serviceCost;

    public StudentServiceListDTO(Long id, int discount, String serviceName, int serviceCost) {
        this.id = id;
        this.discount = discount;
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }
}
