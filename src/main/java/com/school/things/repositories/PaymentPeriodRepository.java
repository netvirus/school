package com.school.things.repositories;

import com.school.things.entities.payment.PaymentPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPeriodRepository extends JpaRepository<PaymentPeriod, Long> {
}
