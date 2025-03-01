package com.school.things.services;

import com.school.things.entities.payment.Payment;
import com.school.things.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getPaymentsByStudentPaymentId(Long studentPaymentId) {
        return paymentRepository.findByStudentPaymentId(studentPaymentId);
    }
}
