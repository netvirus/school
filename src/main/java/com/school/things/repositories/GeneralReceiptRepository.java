package com.school.things.repositories;

import com.school.things.entities.GeneralReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralReceiptRepository extends JpaRepository<GeneralReceipt, Long> {
}
