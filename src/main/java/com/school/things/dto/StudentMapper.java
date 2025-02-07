package com.school.things.dto;

import com.school.things.dto.student.StudentDTO;
import com.school.things.dto.student.StudentListDTO;
import com.school.things.dto.student.StudentPriceDTO;
import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMapper {

    public static <T, R> List<R> convertList(List<T> sourceList, Function<T, R> converter) {
        return sourceList == null ? null : sourceList.stream().map(converter).collect(Collectors.toList());
    }

    public static StudentPriceDTO convertStudentPriceToDTO(StudentPrice studentPrice) {
        return StudentPriceDTO.builder()
                .id(studentPrice.getId())
                .priceDto(PriceMapper.convertPriceToDTO(studentPrice.getPrice()))
                .active(studentPrice.getActive())
                .grade(GradeMapper.convertGradeToDTO(studentPrice.getGrade()))
                .build();
    }

    public static StudentPrice convertStudentPriceFromDTO(StudentPriceDTO studentPriceDTO) {
        return StudentPrice.builder()
                .id(studentPriceDTO.getId())
                .price(PriceMapper.convertPriceFromDTO(studentPriceDTO.getPriceDto()))
                .active(studentPriceDTO.getActive())
                .grade(GradeMapper.convertGradeFromDTO(studentPriceDTO.getGrade()))
                .build();
    }

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
                .studentPricesDto(convertList(student.getStudentPrices(), StudentMapper::convertStudentPriceToDTO))
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
                .studentPrices(convertList(studentDTO.getStudentPricesDto(), StudentMapper::convertStudentPriceFromDTO))
                .build();
    }

    public static StudentListDTO convertStudentToListDTO(Student student) {
        if (student == null) return null;

        return StudentListDTO.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .gender(student.getGender())
                .nationality(student.getNationality())
                .hasContacts(!student.getPhoneNumber().isEmpty() || !student.getAddress().isEmpty())
                .hasParentsContacts(!student.getMotherPhoneNumber().isEmpty() || !student.getFatherPhoneNumber().isEmpty())
                .grade(student.getGrade())
                .hasStudentPrice(!student.getStudentPrices().isEmpty())
                .hasDiscount(student.getStudentPrices()
                        .stream()
                        .flatMap(sp -> sp.getPrice().getStudentServiceLists().stream())
                        .map(StudentServiceList::getDiscount)
                        .anyMatch(discount -> discount > 0))
                .paymentState(true)
                .build();
    }
}
