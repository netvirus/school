package com.school.things.repositories;

import com.school.things.entities.school.LearningCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LearningCycleRepository extends JpaRepository<LearningCycle, Long> {
    Optional<LearningCycle> findByName(String name);

    @Query("SELECT lc FROM LearningCycle lc ORDER BY lc.id DESC LIMIT 1")
    Optional<LearningCycle> findLatestCycle();
}
