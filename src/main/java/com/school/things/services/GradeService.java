package com.school.things.services;

import com.school.things.dto.GradeMapper;
import com.school.things.dto.grade.GradeDTO;
import com.school.things.entities.student.Grade;
import com.school.things.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    GradeMapper gradeMapper;

    public List<GradeDTO> getAllGrades() {
        return gradeRepository.findAll()
                .stream()
                .map(gradeMapper::convertGradeToDTO)
                .collect(Collectors.toList());
    }

    public Optional<GradeDTO> getGradeById(Long id) {
        return gradeRepository.findById(id)
                .map(gradeMapper::convertGradeToDTO);
    }

    public Grade createGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Long id, Grade updatedGrade) {
        return gradeRepository.findById(id).map(existingGrade -> {
            existingGrade.setName(updatedGrade.getName());
            return gradeRepository.save(existingGrade);
        }).orElseThrow(() -> new RuntimeException("Grade not found for id " + id));
    }

    public boolean deleteGrade(Long id) {
        if (gradeRepository.existsById(id)) {
            gradeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
