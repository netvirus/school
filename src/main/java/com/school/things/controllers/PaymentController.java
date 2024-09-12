package com.school.things.controllers;

import com.school.things.entities.Payment;
import com.school.things.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.savePayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        Payment payment = paymentService.updatePayment(id, updatedPayment);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    // Поиск по точной дате
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Payment>> findPaymentsByDate(@PathVariable String date) {
        LocalDateTime paymentDate = LocalDateTime.parse(date);
        List<Payment> payments = paymentService.findPaymentsByDate(paymentDate);
        return ResponseEntity.ok(payments);
    }

    // Поиск по диапазону дат
    @GetMapping("/date-range")
    public ResponseEntity<List<Payment>> findPaymentsByDateRange(
            @RequestParam String startDate, @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<Payment> payments = paymentService.findPaymentsByDateRange(start, end);
        return ResponseEntity.ok(payments);
    }

    // Поиск по payerId
    @GetMapping("/payer/{payerId}")
    public ResponseEntity<List<Payment>> findPaymentsByPayerId(@PathVariable Long payerId) {
        List<Payment> payments = paymentService.findPaymentsByPayerId(payerId);
        return ResponseEntity.ok(payments);
    }
}
