package com.school.things.repositories;

import com.school.things.entities.pricelist.AcademicYearBasePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicYearBasePriceRepository extends JpaRepository<AcademicYearBasePrice, Long> {
    List<AcademicYearBasePrice> findByPriceYear(int priceYear);
}
