package com.school.things.dto.student;

import com.school.things.dto.payment.PaymentDTO;

import java.util.List;

public record StudentPaymentDTO(Long id, int month, int year, boolean paid, double amountPaid, List<PaymentDTO> payments) {
}
