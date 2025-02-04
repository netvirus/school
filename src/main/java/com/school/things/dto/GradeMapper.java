package com.school.things.dto;

import com.school.things.dto.grade.GradeDTO;
import com.school.things.entities.student.Grade;

public class GradeMapper {
    public static GradeDTO convertGradeToDTO(Grade grade) {
        if (grade == null) return null;

        return GradeDTO.builder()
                .id(grade.getId())
                .name(grade.getName())
                .build();
    }

    public static Grade convertGradeFromGTO(GradeDTO gradeDTO) {
        if (gradeDTO == null) return null;

        return Grade.builder()
                .id(gradeDTO.getId())
                .name(gradeDTO.getName())
                .build();
    }
}
