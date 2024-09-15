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

    public PaymentItem updatePaymentItem(Long id, PaymentItem paymentItem) {
        return paymentItemRepository.findById(id)
                .map(existingItem -> {
                    existingItem.setName(paymentItem.getName());
                    return paymentItemRepository.save(existingItem);
                })
                .orElseThrow(() -> new RuntimeException("Payment Item not found"));
    }

    public void deletePaymentItem(Long id) {
        paymentItemRepository.deleteById(id);
    }
}
