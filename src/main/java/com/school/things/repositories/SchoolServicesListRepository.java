package com.school.things.repositories;

import com.school.things.entities.school.SchoolServicesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolServicesListRepository extends JpaRepository<SchoolServicesList, Long> {
}
