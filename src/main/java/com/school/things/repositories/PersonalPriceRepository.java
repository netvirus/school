package com.school.things.repositories;

import com.school.things.entities.pricelist.PersonalPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalPriceRepository extends JpaRepository<PersonalPrice, Long> {
    List<PersonalPrice> findByStudentId(Long studentId);
    List<PersonalPrice> findByAcademicYearAndGradeId(int academicYear, int gradeId);
}
