package com.school.things.repositories;

import com.school.things.entities.pricelist.BasePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePriceRepository extends JpaRepository<BasePrice, Long> {

    @Query(value = "SELECT a.id, a.payment_item_id, a.payment_item_price, a.price_year, " +
            "(SELECT p.name FROM payment_item p WHERE p.id = a.payment_item_id) AS paymentItemName, " +
            "(SELECT g.name FROM grade g WHERE g.id = a.grade_id) AS gradeName " +
            "FROM base_price a", nativeQuery = true)
    List<Object[]> findAllWithPaymentItemNameAndGrade();

    @Query(value = "SELECT a.id, a.payment_item_id, a.payment_item_price, a.price_year, " +
            "(SELECT p.name FROM payment_item p WHERE p.id = a.payment_item_id) AS paymentItemName, " +
            "(SELECT g.name FROM grade g WHERE g.id = a.grade_id) AS gradeName " +
            "FROM base_price a WHERE a.id = ?1", nativeQuery = true)
    Object[] findByIdWithPaymentItemNameAndGrade(Long id);

    @Query(value = "SELECT a.id, a.payment_item_id, a.payment_item_price, a.price_year, " +
            "(SELECT p.name FROM payment_item p WHERE p.id = a.payment_item_id) AS paymentItemName, " +
            "(SELECT g.name FROM grade g WHERE g.id = a.grade_id) AS gradeName " +
            "FROM base_price a WHERE a.grade_id = ?1", nativeQuery = true)
    List<Object[]> findByGradeIdWithPaymentItemName(Long gradeId);
}
