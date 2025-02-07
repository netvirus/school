package com.school.things.dto.grade;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class GradeDTO {
    private Long id = 0L;
    private String name = "There is no grade";
}
