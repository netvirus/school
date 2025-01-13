package com.school.things.repositories;

import com.school.things.entities.school.PriceServicesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceServicesListRepository extends JpaRepository<PriceServicesList, Long> {
}
