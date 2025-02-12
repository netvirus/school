package com.school.things.services;

import com.school.things.entities.payment.PaymentPeriod;
import com.school.things.repositories.PaymentPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentPeriodService {

    @Autowired
    private PaymentPeriodRepository periodRepository;

    public List<PaymentPeriod> getAllPaymentPeriods() {
        return periodRepository.findAll();
    }

    public Optional<PaymentPeriod> getPaymentPeriodById(Long id) {
        return periodRepository.findById(id);
    }

    public PaymentPeriod createPaymentPeriod(PaymentPeriod paymentPeriod) {
        return periodRepository.save(paymentPeriod);
    }

    public PaymentPeriod updatePaymentPeriod(Long id, PaymentPeriod updatedPaymentPeriod) {
        return periodRepository.findById(id).map(existingPaymentPeriod -> {
            existingPaymentPeriod.setId(updatedPaymentPeriod.getId());
            existingPaymentPeriod.setPeriod(updatedPaymentPeriod.getPeriod());
            return periodRepository.save(existingPaymentPeriod);
        }).orElseThrow(() -> new RuntimeException("Payment Period isn't found by id " + id));
    }

    public boolean deletePaymentPeriod(Long id) {
        if (periodRepository.existsById(id)) {
            periodRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
