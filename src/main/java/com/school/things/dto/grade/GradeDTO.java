package com.school.things.dto.grade;

import com.school.things.dto.price.PriceDTO;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class GradeDTO {
    private Long id = 0L;
    private String name = "There is no grade";
    private PriceDTO priceDto;
}
