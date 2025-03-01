package com.school.things.dto;

import com.school.things.dto.student.*;
import com.school.things.entities.price.PriceServiceList;
import com.school.things.entities.school.SchoolServiceList;
import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPayment;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceDiscountList;
import com.school.things.services.StudentPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StudentMapper {
    private final GradeMapper gradeMapper;
    private final PaymentMapper paymentMapper;
    private final StudentPaymentService studentPaymentService;

    @Autowired
    public StudentMapper(GradeMapper gradeMapper, PaymentMapper paymentMapper, StudentPaymentService studentPaymentService) {
        this.gradeMapper = gradeMapper;
        this.paymentMapper = paymentMapper;
        this.studentPaymentService = studentPaymentService;
    }

    public <T, R> List<R> convertList(List<T> sourceList, Function<T, R> converter) {
        return Optional.ofNullable(sourceList)
                .map(list -> list.stream().map(converter).collect(Collectors.toList()))
                .orElse(List.of());
    }

    public StudentPriceDTO convertStudentPriceToDTO(StudentPrice studentPrice) {
        if (studentPrice == null) return null;

        return new StudentPriceDTO(
                studentPrice.getId(),
                gradeMapper.convertGradeToDTO(studentPrice.getGrade()),
                convertList(studentPrice.getStudentServiceDiscountList(), this::convertStudentServiceListToDTO),
                paymentMapper.convertPaymentCurrencyToDTO(studentPrice.getPaymentCurrency()),
                studentPaymentService.getPaymentStatusByStudentPriceId(studentPrice.getId())
        );
    }

    public List<StudentPriceDTO> convertStudentPrices(List<StudentPrice> studentPrices) {
        return convertList(studentPrices, this::convertStudentPriceToDTO);
    }

    public StudentPrice convertStudentPriceFromDTO(StudentPriceDTO studentPriceDTO) {
        if (studentPriceDTO == null) return null;

        return StudentPrice.builder()
                .id(studentPriceDTO.id())
                .grade(gradeMapper.convertGradeFromDTO(studentPriceDTO.gradeDto()))
                .studentServiceDiscountList(convertList(
                        studentPriceDTO.studentServiceDiscountListDto(),
                        this::convertStudentServiceDiscountListFromDTO))
                .build();
    }

    public List<StudentPaymentDTO> convertStudentPayments(List<StudentPayment> payments) {
        return convertList(payments, this::convertStudentPaymentToDTO);
    }

    public StudentPaymentDTO convertStudentPaymentToDTO(StudentPayment studentPayment) {
        if (studentPayment == null) return null;

        return new StudentPaymentDTO(
                studentPayment.getId(),
                studentPayment.getMonth(),
                studentPayment.getYear(),
                studentPayment.isPaid(),
                studentPayment.getAmountPaid()
        );
    }

    public StudentDTO convertStudentToDTO(Student student) {
        if (student == null) return null;

        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .gender(student.getGender())
                .nationality(student.getNationality())
                .phoneNumber(Optional.ofNullable(student.getPhoneNumber()).orElse(""))
                .address(Optional.ofNullable(student.getAddress()).orElse(""))
                .createdAt(student.getCreatedAt())
                .grade(student.getGrade())
                .motherName(student.getMotherName())
                .fatherName(student.getFatherName())
                .motherPhoneNumber(Optional.ofNullable(student.getMotherPhoneNumber()).orElse(""))
                .fatherPhoneNumber(Optional.ofNullable(student.getFatherPhoneNumber()).orElse(""))
                .studentPricesDto(convertStudentPrices(student.getStudentPrices()))
                .build();
    }

    public Student convertStudentFromDTO(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

        return Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .age(studentDTO.getAge())
                .gender(studentDTO.getGender())
                .nationality(studentDTO.getNationality())
                .phoneNumber(Optional.ofNullable(studentDTO.getPhoneNumber()).orElse(""))
                .address(Optional.ofNullable(studentDTO.getAddress()).orElse(""))
                .createdAt(studentDTO.getCreatedAt())
                .grade(studentDTO.getGrade())
                .motherName(studentDTO.getMotherName())
                .fatherName(studentDTO.getFatherName())
                .motherPhoneNumber(Optional.ofNullable(studentDTO.getMotherPhoneNumber()).orElse(""))
                .fatherPhoneNumber(Optional.ofNullable(studentDTO.getFatherPhoneNumber()).orElse(""))
                .studentPrices(convertList(studentDTO.getStudentPricesDto(), this::convertStudentPriceFromDTO))
                .build();
    }

    public StudentListDTO convertStudentToListDTO(Student student) {
        if (student == null) return null;

        return StudentListDTO.builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .gender(student.getGender())
                .nationality(student.getNationality())
                .hasContacts(
                        Optional.ofNullable(student.getPhoneNumber()).map(p -> !p.isEmpty()).orElse(false) ||
                                Optional.ofNullable(student.getAddress()).map(a -> !a.isEmpty()).orElse(false))
                .hasParentsContacts(
                        Optional.ofNullable(student.getMotherPhoneNumber()).map(p -> !p.isEmpty()).orElse(false) ||
                                Optional.ofNullable(student.getFatherPhoneNumber()).map(p -> !p.isEmpty()).orElse(false))
                .grade(student.getGrade())
                .hasStudentPrice(Optional.ofNullable(student.getStudentPrices()).map(p -> !p.isEmpty()).orElse(false))
                .paymentState(true) // TODO: Подумать, откуда брать paymentState
                .build();
    }

    public StudentServiceDiscountListDTO convertStudentServiceListToDTO(StudentServiceDiscountList entity) {
        if (entity == null) return null;

        return StudentServiceDiscountListDTO.builder()
                .id(entity.getId())
                .discount(entity.getDiscount())
                .serviceName(
                        Optional.ofNullable(entity.getPriceServiceList())
                                .map(PriceServiceList::getSchoolServiceList)
                                .map(SchoolServiceList::getServiceName)
                                .orElse(null)
                )
                .costWithDiscount(entity.getCostWithDiscount())
                .build();
    }

    public StudentServiceDiscountList convertStudentServiceDiscountListFromDTO(StudentServiceDiscountListDTO dto) {
        if (dto == null) return null;

        return StudentServiceDiscountList.builder()
                .id(dto.getId())
                .discount(dto.getDiscount())
                .priceServiceList(new PriceServiceList())
                .build();
    }
}
