package com.school.things.dto;

import com.school.things.dto.payment.PaymentCurrencyDTO;
import com.school.things.dto.payment.PaymentDTO;
import com.school.things.entities.payment.Payment;
import com.school.things.entities.payment.PaymentCurrency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMapper {

    public PaymentCurrencyDTO convertPaymentCurrencyToDTO(PaymentCurrency paymentCurrency) {
        if (paymentCurrency == null) return null;

        return new PaymentCurrencyDTO(paymentCurrency.getId(), paymentCurrency.getName());
    }

    public PaymentCurrency convertPaymentCurrencyFromDTO(PaymentCurrencyDTO paymentCurrencyDTO) {
        if (paymentCurrencyDTO == null) return null;

        return new PaymentCurrency(paymentCurrencyDTO.id(), paymentCurrencyDTO.name());
    }

    public PaymentDTO convertPaymentToDTO(Payment payment) {
        if (payment == null) return null;

        return new PaymentDTO(
                payment.getId(),
                payment.getMonth(),
                payment.getYear(),
                payment.getAmount()
        );
    }

    public Payment convertPaymentFromDTO(PaymentDTO paymentDTO) {
        if (paymentDTO == null) return null;

        Payment payment = new Payment();
        payment.setId(paymentDTO.id());
        payment.setAmount(paymentDTO.amount());
        payment.setMonth(paymentDTO.month());
        payment.setYear(paymentDTO.year());
        return payment;
    }

    public List<PaymentDTO> convertPaymentsToDTOList(List<Payment> payments) {
        return payments.stream()
                .map(this::convertPaymentToDTO)
                .collect(Collectors.toList());
    }

    public List<Payment> convertDTOListToPayments(List<PaymentDTO> paymentDTOs) {
        return paymentDTOs.stream()
                .map(this::convertPaymentFromDTO)
                .collect(Collectors.toList());
    }
}
