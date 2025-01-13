package com.school.things.repositories;

import com.school.things.entities.student.StudentPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPriceRepository extends JpaRepository<StudentPrice, Long> {

}
