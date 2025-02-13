package com.school.things.dto.price;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PriceDTO {
    private Long id;
    private String name;
    private List<PriceServiceListDTO> priceServiceList;
}
