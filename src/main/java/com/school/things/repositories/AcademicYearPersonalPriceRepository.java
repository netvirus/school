package com.school.things.repositories;

import com.school.things.entities.pricelist.AcademicYearPersonalPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicYearPersonalPriceRepository extends JpaRepository<AcademicYearPersonalPrice, Long> {
    List<AcademicYearPersonalPrice> findByStudentId(Long studentId);
    List<AcademicYearPersonalPrice> findByAcademicYearAndGradeId(int academicYear, int gradeId);
}
