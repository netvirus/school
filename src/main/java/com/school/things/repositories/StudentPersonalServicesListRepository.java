package com.school.things.repositories;

import com.school.things.entities.prices.StudentPersonalServicesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersonalServicesListRepository extends JpaRepository<StudentPersonalServicesList, Long> {
}
