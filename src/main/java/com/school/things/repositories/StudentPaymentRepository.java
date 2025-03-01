package com.school.things.repositories;

import com.school.things.entities.student.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Long> {

    @Query("SELECT sp FROM StudentPayment sp WHERE sp.studentPrice.student.id = :studentId AND sp.paid = false")
    List<StudentPayment> findUnpaidPaymentsByStudentId(@Param("studentId") Long studentId);

    List<StudentPayment> findByStudentPriceId(Long studentPriceId);
}
