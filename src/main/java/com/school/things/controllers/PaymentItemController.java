package com.school.things.controllers;

import com.school.things.entities.pricelist.PaymentItem;
import com.school.things.services.PaymentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-items")
public class PaymentItemController {

    @Autowired
    private PaymentItemService paymentItemService;

    @GetMapping
    public List<PaymentItem> getAllPaymentItems() {
        return paymentItemService.getAllPaymentItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentItem> getPaymentItemById(@PathVariable Long id) {
        Optional<PaymentItem> paymentItem = paymentItemService.getPaymentItemById(id);
        return paymentItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymentItem> createPaymentItem(@RequestBody PaymentItem paymentItem) {
        PaymentItem createdPaymentItem = paymentItemService.createPaymentItem(paymentItem);
        return ResponseEntity.ok(createdPaymentItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentItem> updatePaymentItem(@PathVariable Long id, @RequestBody PaymentItem paymentItem) {
        PaymentItem updatedPaymentItem = paymentItemService.updatePaymentItem(id, paymentItem);
        return ResponseEntity.ok(updatedPaymentItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentItem(@PathVariable Long id) {
        boolean deleted = paymentItemService.deletePaymentItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
