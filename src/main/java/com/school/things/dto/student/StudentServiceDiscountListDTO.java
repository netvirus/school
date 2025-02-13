package com.school.things.dto.student;

import lombok.*;

@Data
@Builder
public class StudentServiceDiscountListDTO {
    private Long id;
    private double discount;
    private String serviceName;
    private double serviceCost;
    private String serviceType;
}
