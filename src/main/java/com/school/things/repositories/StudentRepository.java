package com.school.things.repositories;

import com.school.things.entities.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query("SELECT DISTINCT s FROM Student s " +
//            "LEFT JOIN FETCH s.studentPrice " +
//            "LEFT JOIN FETCH s.studentDiscounts " +
//            "WHERE s.id = :id")
//    Optional<Student> findStudentById(@Param("id") Long id);
}
