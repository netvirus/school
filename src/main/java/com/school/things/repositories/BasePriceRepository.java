package com.school.things.repositories;

import com.school.things.entities.pricelist.BasePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePriceRepository extends JpaRepository<BasePrice, Long> {

    @Query("SELECT bp FROM BasePrice bp JOIN FETCH bp.paymentItem JOIN FETCH bp.grade")
    List<BasePrice> findAllWithPaymentItemAndGrade();

    @Query("SELECT bp FROM BasePrice bp JOIN FETCH bp.paymentItem JOIN FETCH bp.grade WHERE bp.id = :id")
    BasePrice findByIdWithPaymentItemAndGrade(Long id);
}
