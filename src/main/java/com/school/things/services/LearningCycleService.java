package com.school.things.services;

import com.school.things.entities.school.LearningCycle;
import com.school.things.entities.school.LearningCycleMonth;
import com.school.things.repositories.LearningCycleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LearningCycleService {
    @Autowired
    private LearningCycleRepository learningCycleRepository;

    @Transactional
    public LearningCycle createLearningCycle(String name, LocalDate startDate, LocalDate endDate) {
        if (learningCycleRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException("LearningCycle already exists.");
        }

        LearningCycle learningCycle = new LearningCycle();
        learningCycle.setName(name);

        List<LearningCycleMonth> months = new ArrayList<>();
        LocalDate current = startDate;

        while (!current.isAfter(endDate)) {
            LearningCycleMonth month = new LearningCycleMonth();
            month.setLearningCycle(learningCycle);
            month.setMonth(current.getMonthValue());
            month.setYear(current.getYear());
            months.add(month);
            current = current.plusMonths(1);
        }

        learningCycle.setMonths(months);

        return learningCycleRepository.save(learningCycle);
    }

    public LearningCycle getLatestCycle() {
        return learningCycleRepository.findLatestCycle()
                .orElseThrow(() -> new RuntimeException("There is no Learning Cycle"));
    }
}
