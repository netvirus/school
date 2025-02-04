package com.school.things.dto;

import com.school.things.dto.student.StudentDTO;
import com.school.things.dto.student.StudentPriceDTO;
import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPrice;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMapper {
    public static StudentDTO convertStudentToDTO(Student student) {
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
                .studentPricesDto(convertListToDTO(student.getStudentPrices(), StudentMapper::convertStudentToDTO))
                .build();
    }

    public static Student convertStudentFromDTO(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

        return Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .age(studentDTO.getAge())
                .gender(studentDTO.getGender())
                .nationality(studentDTO.getNationality())
                .phoneNumber(studentDTO.getPhoneNumber())
                .address(studentDTO.getAddress())
                .createdAt(studentDTO.getCreatedAt())
                .grade(studentDTO.getGrade())
                .motherName(studentDTO.getMotherName())
                .fatherName(studentDTO.getFatherName())
                .motherPhoneNumber(studentDTO.getMotherPhoneNumber())
                .fatherPhoneNumber(studentDTO.getFatherPhoneNumber())
                .studentPrices(convertListFromDTO(studentDTO.getStudentPricesDto(), StudentMapper::convertStudentPriceFromDTO))
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

    private static <T, R> List<T> convertListFromDTO(List<R> sourceList, Function<R, T> converter) {
        return Optional.ofNullable(sourceList)
                .orElse(Collections.emptyList())
                .stream()
                .map(converter)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static StudentPriceDTO convertStudentToDTO(StudentPrice studentPrice) {
        if (studentPrice == null) return null;

        return StudentPriceDTO.builder()
                .id(studentPrice.getId())
                .priceDto(Optional.ofNullable(studentPrice.getPrice())
                        .map(PriceMapper::convertPriceToDTO)
                        .orElse(null))
                .active(studentPrice.getActive())
                .grade(Optional.ofNullable(studentPrice.getGrade())
                        .map(GradeMapper::convertGradeToDTO)
                        .orElse(null))
                .build();
    }

    public static StudentPrice convertStudentPriceFromDTO(StudentPriceDTO studentPriceDTO) {
        if (studentPriceDTO == null) return null;

        return StudentPrice.builder()
                .id(studentPriceDTO.getId())
                .price(Optional.ofNullable(studentPriceDTO.getPriceDto())
                        .map(PriceMapper::convertPriceFromDTO)
                        .orElse(null))
                .active(studentPriceDTO.getActive())
                .grade(Optional.ofNullable(studentPriceDTO.getGrade())
                        .map(GradeMapper::convertGradeFromGTO)
                        .orElse(null))
                .build();
    }
}
