package com.school.things.repositories;

import com.school.things.entities.student.StudentPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentPriceRepository extends JpaRepository<StudentPrice, Long> {
//    @Query("SELECT pp FROM StudentPrice pp " +
//            "LEFT JOIN FETCH pp.price p " +
//            "LEFT JOIN FETCH p.priceServicesList psl " +
//            "LEFT JOIN FETCH psl.schoolServicesList " +
//            "LEFT JOIN FETCH pp.student.studentDiscounts sd " +
//            "WHERE pp.student.id = :studentId AND pp.isActive = true")
//    Optional<StudentPrice> findActivePriceWithDetails(Long studentId);
}
