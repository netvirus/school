package com.school.things.dto.student;

public record StudentPaymentDTO(Long id, int month, int year, boolean paid, double amountPaid) {
}
