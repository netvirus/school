package com.school.things.dto.student;

import java.util.Date;
import java.util.List;

public record StudentDTO(
        Long id,
        String firstName,
        String lastName,
        int age,
        String gender,
        String nationality,
        String phoneNumber,
        String address,
        Date createdAt,
        String grade,
        String motherName,
        String fatherName,
        String motherPhoneNumber,
        String fatherPhoneNumber,
        List<StudentPriceDTO> studentPricesDto
) {
}
