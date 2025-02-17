package com.school.things.dto;

import com.school.things.dto.student.StudentDTO;
import com.school.things.dto.student.StudentListDTO;
import com.school.things.dto.student.StudentPriceDTO;
import com.school.things.dto.student.StudentServiceDiscountListDTO;
import com.school.things.entities.price.PriceServiceList;
import com.school.things.entities.school.SchoolServiceList;
import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceDiscountList;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMapper {

    public static <T, R> List<R> convertList(List<T> sourceList, Function<T, R> converter) {
        return sourceList == null ? null : sourceList.stream().map(converter).collect(Collectors.toList());
    }

    public static StudentPriceDTO convertStudentPriceToDTO(StudentPrice studentPrice) {
        return StudentPriceDTO.builder()
                .id(studentPrice.getId())
                .active(studentPrice.getActive())
                .paymentPeriod(studentPrice.getPaymentPeriod())
                .gradeDto(GradeMapper.convertGradeToDTO(studentPrice.getGrade()))
                .studentServiceDiscountListDto(convertList(studentPrice.getStudentServiceDiscountList(), StudentMapper::convertStudentServiceListToDTO))
                .paymentCurrencyDTO(PaymentMapper.convertPaymentCurrencyToDTO(studentPrice.getPaymentCurrency()))
                .build();
    }

    public static StudentPrice convertStudentPriceFromDTO(StudentPriceDTO studentPriceDTO) {
        return StudentPrice.builder()
                .id(studentPriceDTO.getId())
                .active(studentPriceDTO.getActive())
                .paymentPeriod(studentPriceDTO.getPaymentPeriod())
                .grade(GradeMapper.convertGradeFromDTO(studentPriceDTO.getGradeDto()))
                .studentServiceDiscountList(convertList(studentPriceDTO.getStudentServiceDiscountListDto(), StudentMapper::convertStudentServiceDiscountListFromDTO))
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
                .paymentState(true)
                .build();
    }

    public static StudentServiceDiscountListDTO convertStudentServiceListToDTO(StudentServiceDiscountList entity) {
        if (entity == null) return null;

        return StudentServiceDiscountListDTO.builder()
                .id(entity.getId())
                .discount(entity.getDiscount())
                .serviceName(Optional.ofNullable(entity.getPriceServiceList())
                        .map(PriceServiceList::getSchoolServiceList)
                        .map(SchoolServiceList::getServiceName)
                        .orElse(null))
                .costWithDiscount(Discount(entity.getPriceServiceList().getCost(), entity.getDiscount()))
                .build();
    }

    public static StudentServiceDiscountList convertStudentServiceDiscountListFromDTO(StudentServiceDiscountListDTO entity) {
        if (entity == null) return null;

        return StudentServiceDiscountList.builder()
                .id(entity.getId())
                .discount(entity.getDiscount())
                .build();
    }

    public static double Discount(double amount, double discountPercent) {
        return amount - (amount * discountPercent / 100);
    }
}
