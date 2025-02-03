package com.school.things.dto.student;

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
    private double discount;
    private String serviceName;
    private double serviceCost;
}
