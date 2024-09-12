package com.school.things.repositories;

import com.school.things.entities.pricelist.PersonalDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalDiscountRepository extends JpaRepository<PersonalDiscount, Long> {
    Optional<PersonalDiscount> findByStudentId(Long studentId);
}
