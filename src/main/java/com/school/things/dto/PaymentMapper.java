package com.school.things.dto;

import com.school.things.dto.payment.PaymentCurrencyDTO;
import com.school.things.dto.payment.PaymentPeriodDTO;
import com.school.things.entities.payment.PaymentCurrency;
import com.school.things.entities.payment.PaymentPeriod;

public class PaymentMapper {
    public static PaymentPeriodDTO convertPaymentPeriodToDTO(PaymentPeriod paymentPeriod) {
        if (paymentPeriod == null) return null;

        return PaymentPeriodDTO.builder()
                .id(paymentPeriod.getId())
                .period(paymentPeriod.getPeriod())
                .paymentCurrencyDTO(convertPaymentCurrencyToDTO(paymentPeriod.getCurrency()))
                .build();
    }

    public static PaymentPeriod convertPaymentPeriodFromDTO(PaymentPeriodDTO paymentPeriodDTO) {
        if (paymentPeriodDTO == null) return null;

        return PaymentPeriod.builder()
                .id(paymentPeriodDTO.getId())
                .period(paymentPeriodDTO.getPeriod())
                .build();
    }

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
