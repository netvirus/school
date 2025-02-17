package com.school.things.dto.student;

import lombok.*;

@Data
@Builder
public class StudentServiceDiscountListDTO {
    private Long id;
    private double discount = 0;
    private String serviceName;
    private double costWithDiscount;
}
