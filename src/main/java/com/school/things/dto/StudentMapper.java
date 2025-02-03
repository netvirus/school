package com.school.things.dto;

import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPrice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMapper {
    public static StudentDTO convertToDTO(Student student) {
        if (student == null) return null;

        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .gender(student.getGender())
                .nationality(student.getNationality())
                .phoneNumber(student.getPhoneNumber())
                .address(student.getAddress())
                .createdAt(student.getCreatedAt())
                .grade(student.getGrade())
                .motherName(student.getMotherName())
                .fatherName(student.getFatherName())
                .motherPhoneNumber(student.getMotherPhoneNumber())
                .fatherPhoneNumber(student.getFatherPhoneNumber())
                .studentPricesDto(convertListToDTO(student.getStudentPrices(), StudentMapper::convertToDTO))
                .build();
    }

    private static <T, R> List<R> convertListToDTO(List<T> sourceList, Function<T, R> converter) {
        return Optional.ofNullable(sourceList)
                .orElse(Collections.emptyList())
                .stream()
                .map(converter)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static StudentPriceDTO convertToDTO(StudentPrice studentPrice) {
        if (studentPrice == null) return null;

        return StudentPriceDTO.builder()
                .id(studentPrice.getId())
                .priceDto(Optional.ofNullable(studentPrice.getPrice())
                        .map(PriceMapper::convertPriceToDTO)
                        .orElse(null))
                .active(studentPrice.getActive())
                .build();
    }
}
