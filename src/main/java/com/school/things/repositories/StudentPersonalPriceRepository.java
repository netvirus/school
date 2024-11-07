package com.school.things.repositories;

import com.school.things.entities.prices.StudentPersonalPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersonalPriceRepository extends JpaRepository<StudentPersonalPrice, Long> {

}
