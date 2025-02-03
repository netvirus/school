package com.school.things.dto.student;

import com.school.things.dto.grade.GradeDTO;
import com.school.things.dto.price.PriceDTO;
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
    private GradeDTO grade;
}
