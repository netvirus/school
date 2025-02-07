package com.school.things.dto.price;

import lombok.*;

@Data
@Builder
public class PriceServiceListDTO {
    private Long id;
    private double cost;
    private Long schoolServiceId;
    private String schoolServiceName;

    public PriceServiceListDTO(Long id, double cost, Long schoolServiceId, String schoolServiceName) {
        this.id = id;
        this.cost = cost;
        this.schoolServiceId = schoolServiceId;
        this.schoolServiceName = schoolServiceName;
    }
}
