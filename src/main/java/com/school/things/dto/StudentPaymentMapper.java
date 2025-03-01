package com.school.things.dto;

import com.school.things.dto.student.StudentPaymentDTO;
import com.school.things.entities.student.StudentPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentPaymentMapper {

    @Autowired
    private final PaymentMapper paymentMapper;

    public StudentPaymentMapper(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public StudentPaymentDTO toDTO(StudentPayment payment) {
        if (payment == null) return null;
        return new StudentPaymentDTO(payment.getId(), payment.getMonth(), payment.getYear(), payment.isPaid(), payment.getAmountPaid(), paymentMapper.convertPaymentsToDTOList(payment.getPayments()));
    }

    public List<StudentPaymentDTO> toDTOList(List<StudentPayment> payments) {
        return payments.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
