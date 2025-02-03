package com.school.things.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StudentPriceDTO {
    private Long id;
    private PriceDTO priceDto;
    private Boolean active;
}
