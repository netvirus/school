package com.school.things.repositories;

import com.school.things.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Поиск платежей по payerId
    List<Payment> findByPayerId(Long payerId);

    // Поиск платежей по точной дате
    List<Payment> findByPaymentDate(LocalDateTime paymentDate);

    // Поиск платежей в диапазоне дат
    List<Payment> findByPaymentDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
