package com.school.things.repositories;

import com.school.things.entities.price.PriceServiceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceServiceListRepository extends JpaRepository<PriceServiceList, Long> {
}
