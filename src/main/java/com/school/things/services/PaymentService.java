package com.school.things.services;

import com.school.things.entities.Payment;
import com.school.things.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(existingPayment -> {
                    existingPayment.setAmount(updatedPayment.getAmount());
                    existingPayment.setPayerId(updatedPayment.getPayerId());
                    existingPayment.setNumberOfMonth(updatedPayment.getNumberOfMonth());
                    existingPayment.setDiscount(updatedPayment.getDiscount());
                    existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
                    existingPayment.setReceiptId(updatedPayment.getReceiptId());  // Обновление Receipt ID
                    return paymentRepository.save(existingPayment);
                })
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    // Поиск платежей по receiptId
    public List<Payment> findPaymentsByReceiptId(String receiptId) {
        return paymentRepository.findByReceiptId(receiptId);
    }

    // Поиск платежей по payerId (student.id)
    public List<Payment> findPaymentsByPayerId(Long payerId) {
        return paymentRepository.findByPayerId(payerId);
    }

    // Поиск платежей по точной дате
    public List<Payment> findPaymentsByDate(LocalDateTime paymentDate) {
        return paymentRepository.findByPaymentDate(paymentDate);
    }

    // Поиск платежей в диапазоне дат
    public List<Payment> findPaymentsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return paymentRepository.findByPaymentDateBetween(startDate, endDate);
    }
}
