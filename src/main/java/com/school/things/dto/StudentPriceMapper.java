package com.school.things.dto;

import com.school.things.entities.student.StudentPrice;

import java.util.Optional;

public class StudentPriceMapper {
    public static StudentPriceDTO fromStudentPrices(Optional<StudentPrice> studentPrice) {
        return new StudentPriceDTO(
                studentPrice.get().getId(),
                studentPrice.get().getPrice(),
                studentPrice.get().getStudentDiscount()
        );
    }
}
