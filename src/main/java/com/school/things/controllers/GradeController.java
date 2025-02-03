package com.school.things.controllers;

import com.school.things.entities.student.Grade;
import com.school.things.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        return grade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade createdGrade = gradeService.createGrade(grade);
        return ResponseEntity.ok(createdGrade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        Grade updatedGrade = gradeService.updateGrade(id, grade);
        return ResponseEntity.ok(updatedGrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        boolean deleted = gradeService.deleteGrade(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
