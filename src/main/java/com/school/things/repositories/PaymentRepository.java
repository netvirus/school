package com.school.things.repositories;

import com.school.things.entities.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentPaymentId(Long studentPaymentId);

    @Query("SELECT p FROM Payment p WHERE p.studentPayment.studentPrice.id = :studentPriceId")
    List<Payment> findByStudentPriceId(@Param("studentPriceId") Long studentPriceId);
}
