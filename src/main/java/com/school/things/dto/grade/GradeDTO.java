package com.school.things.dto.grade;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GradeDTO {
    private Long id;
    private String name;
}
