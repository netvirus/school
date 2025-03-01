package com.school.things.dto;

import com.school.things.dto.payment.PaymentDTO;
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

        List<PaymentDTO> paymentDTOs = Optional.ofNullable(studentPayment.getPayments())
                .map(payments -> payments.stream()
                        .map(paymentMapper::convertPaymentToDTO)
                        .collect(Collectors.toList()))
                .orElse(List.of());

        return new StudentPaymentDTO(
                studentPayment.getId(),
                studentPayment.getMonth(),
                studentPayment.getYear(),
                studentPayment.isPaid(),
                studentPayment.getAmountPaid(),
                paymentDTOs
        );
    }

    public StudentDTO convertStudentToDTO(Student student) {
        if (student == null) return null;

        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getGender(),
                student.getNationality(),
                Optional.ofNullable(student.getPhoneNumber()).orElse(""),
                Optional.ofNullable(student.getAddress()).orElse(""),
                student.getCreatedAt(),
                student.getGrade(),
                student.getMotherName(),
                student.getFatherName(),
                Optional.ofNullable(student.getMotherPhoneNumber()).orElse(""),
                Optional.ofNullable(student.getFatherPhoneNumber()).orElse(""),
                convertStudentPrices(student.getStudentPrices())
        );
    }

    public Student convertStudentFromDTO(StudentDTO studentDTO) {
        if (studentDTO == null) return null;

        return Student.builder()
                .id(studentDTO.id())
                .firstName(studentDTO.firstName())
                .lastName(studentDTO.lastName())
                .age(studentDTO.age())
                .gender(studentDTO.gender())
                .nationality(studentDTO.nationality())
                .phoneNumber(Optional.ofNullable(studentDTO.phoneNumber()).orElse(""))
                .address(Optional.ofNullable(studentDTO.address()).orElse(""))
                .createdAt(studentDTO.createdAt())
                .grade(studentDTO.grade())
                .motherName(studentDTO.motherName())
                .fatherName(studentDTO.fatherName())
                .motherPhoneNumber(Optional.ofNullable(studentDTO.motherPhoneNumber()).orElse(""))
                .fatherPhoneNumber(Optional.ofNullable(studentDTO.fatherPhoneNumber()).orElse(""))
                .studentPrices(convertList(studentDTO.studentPricesDto(), this::convertStudentPriceFromDTO))
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
