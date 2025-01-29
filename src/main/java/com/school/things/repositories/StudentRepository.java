package com.school.things.repositories;

import com.school.things.entities.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.studentPrice sp LEFT JOIN FETCH sp.price LEFT JOIN FETCH sp.studentDiscount WHERE s.student_id = :id")
    Optional<Student> findStudentById(@Param("id") Long id);
}
