package com.school.things.repositories;

import com.school.things.entities.school.LearningCycleMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningCycleMonthRepository extends JpaRepository<LearningCycleMonth, Long> {
}
