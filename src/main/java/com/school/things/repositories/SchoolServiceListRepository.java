package com.school.things.repositories;

import com.school.things.entities.school.SchoolServiceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolServiceListRepository extends JpaRepository<SchoolServiceList, Long> {
}
