package com.school.things.dto;

import com.school.things.dto.grade.GradeDTO;
import com.school.things.entities.student.Grade;
import org.springframework.stereotype.Service;

@Service
public class GradeMapper {
    public GradeDTO convertGradeToDTO(Grade grade) {
        if (grade == null) return null;

        return GradeDTO.builder()
                .id(grade.getId())
                .name(grade.getName())
                .priceDto(PriceMapper.convertPriceToDTO(grade.getPrice()))
                .build();
    }

    public Grade convertGradeFromDTO(GradeDTO gradeDTO) {
        if (gradeDTO == null) return null;

        return Grade.builder()
                .id(gradeDTO.getId())
                .name(gradeDTO.getName())
                .price(PriceMapper.convertPriceFromDTO(gradeDTO.getPriceDto()))
                .build();
    }
}
