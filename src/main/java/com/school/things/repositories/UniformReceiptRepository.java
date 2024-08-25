package com.school.things.repositories;

import com.school.things.entities.UniformReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniformReceiptRepository extends JpaRepository<UniformReceipt, Long> {
}
