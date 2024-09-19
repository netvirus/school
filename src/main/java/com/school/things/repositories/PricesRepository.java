package com.school.things.repositories;

import com.school.things.entities.pricelist.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

}
