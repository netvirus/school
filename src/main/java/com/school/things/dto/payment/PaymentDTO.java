package com.school.things.dto.payment;

public record PaymentDTO(
        Long id,
        int month,
        int year,
        double amount
) {}
