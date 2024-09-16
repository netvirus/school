package com.school.things.services;

import com.school.things.entities.Grade;
import com.school.things.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade updatedGrade) {
        return gradeRepository.findById(id)
                .map(existingGrade -> {
                    existingGrade.setName(updatedGrade.getName());
                    return gradeRepository.save(existingGrade);
                })
                .orElseThrow(() -> new RuntimeException("Grade not found"));
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
