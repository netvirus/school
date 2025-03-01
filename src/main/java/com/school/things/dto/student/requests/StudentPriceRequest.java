package com.school.things.dto.student.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentPriceRequest {
    private Long studentId;
    private Long gradeId;
}
