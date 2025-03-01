package com.school.things.dto;

import com.school.things.dto.student.StudentPaymentDTO;
import com.school.things.entities.student.StudentPayment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentPaymentMapper {

    public StudentPaymentDTO toDTO(StudentPayment payment) {
        if (payment == null) return null;
        return new StudentPaymentDTO(payment.getId(), payment.getMonth(), payment.getYear(), payment.isPaid(), payment.getAmountPaid());
    }

    public List<StudentPaymentDTO> toDTOList(List<StudentPayment> payments) {
        return payments.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
