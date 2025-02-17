package com.school.things.dto;

import com.school.things.dto.payment.PaymentCurrencyDTO;
import com.school.things.entities.payment.PaymentCurrency;

public class PaymentMapper {
    public static PaymentCurrencyDTO convertPaymentCurrencyToDTO(PaymentCurrency paymentCurrency) {
        if (paymentCurrency == null) return null;

        return PaymentCurrencyDTO.builder()
                .id(paymentCurrency.getId())
                .name(paymentCurrency.getName())
                .build();
    }

    public static PaymentCurrency convertPaymentCurrencyDTOFromDTO(PaymentCurrencyDTO paymentCurrencyDTO) {
        if (paymentCurrencyDTO == null) return null;

        return PaymentCurrency.builder()
                .id(paymentCurrencyDTO.getId())
                .name(paymentCurrencyDTO.getName())
                .build();
    }
}
