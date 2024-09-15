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
        return paymentItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PaymentItem createPaymentItem(@RequestBody PaymentItem paymentItem) {
        return paymentItemService.createPaymentItem(paymentItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentItem> updatePaymentItem(@PathVariable Long id, @RequestBody PaymentItem paymentItem) {
        return ResponseEntity.ok(paymentItemService.updatePaymentItem(id, paymentItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentItem(@PathVariable Long id) {
        paymentItemService.deletePaymentItem(id);
        return ResponseEntity.noContent().build();
    }
}
