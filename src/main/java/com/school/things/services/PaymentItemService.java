package com.school.things.services;

import com.school.things.entities.pricelist.PaymentItem;
import com.school.things.repositories.PaymentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentItemService {

    @Autowired
    private PaymentItemRepository paymentItemRepository;

    public List<PaymentItem> getAllPaymentItems() {
        return paymentItemRepository.findAll();
    }

    public Optional<PaymentItem> getPaymentItemById(Long id) {
        return paymentItemRepository.findById(id);
    }

    public PaymentItem createPaymentItem(PaymentItem paymentItem) {
        return paymentItemRepository.save(paymentItem);
    }

    public PaymentItem updatePaymentItem(Long id, PaymentItem updatedPaymentItem) {
        return paymentItemRepository.findById(id).map(existingPaymentItem -> {
            existingPaymentItem.setName(updatedPaymentItem.getName());
            return paymentItemRepository.save(existingPaymentItem);
        }).orElseThrow(() -> new RuntimeException("PaymentItem not found for id " + id));
    }

    public boolean deletePaymentItem(Long id) {
        if (paymentItemRepository.existsById(id)) {
            paymentItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
