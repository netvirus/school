package com.school.things.dto;

import com.school.things.dto.payment.PaymentCurrencyDTO;
import com.school.things.entities.payment.PaymentCurrency;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public PaymentCurrencyDTO convertPaymentCurrencyToDTO(PaymentCurrency paymentCurrency) {
        if (paymentCurrency == null) return null;

        return PaymentCurrencyDTO.builder()
                .id(paymentCurrency.getId())
                .name(paymentCurrency.getName())
                .build();
    }

    public PaymentCurrency convertPaymentCurrencyDTOFromDTO(PaymentCurrencyDTO paymentCurrencyDTO) {
        if (paymentCurrencyDTO == null) return null;

        return PaymentCurrency.builder()
                .id(paymentCurrencyDTO.getId())
                .name(paymentCurrencyDTO.getName())
                .build();
    }
}
