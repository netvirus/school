package com.school.things.repositories;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.entities.pricelist.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePriceRepository extends JpaRepository<BasePrice, Long> {
    List<BasePrice> findByPrices(Prices prices);
}
