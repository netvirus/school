package com.school.things.controllers;

import com.school.things.entities.pricelist.PersonalPrice;
import com.school.things.services.PersonalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academic-year-personal-prices")
public class PersonalPriceController {

    @Autowired
    private PersonalPriceService academicYearPersonalPriceService;

    @GetMapping
    public List<PersonalPrice> getAllAcademicYearPersonalPrices() {
        return academicYearPersonalPriceService.getAllAcademicYearPersonalPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalPrice> getAcademicYearPersonalPriceById(@PathVariable Long id) {
        Optional<PersonalPrice> academicYearPersonalPrice = academicYearPersonalPriceService.getAcademicYearPersonalPriceById(id);
        return academicYearPersonalPrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public List<PersonalPrice> getAcademicYearPersonalPricesByStudentId(@PathVariable Long studentId) {
        return academicYearPersonalPriceService.getAcademicYearPersonalPricesByStudentId(studentId);
    }

    @GetMapping("/year/{year}/grade/{gradeId}")
    public List<PersonalPrice> getAcademicYearPersonalPricesByYearAndGrade(@PathVariable int year, @PathVariable int gradeId) {
        return academicYearPersonalPriceService.getAcademicYearPersonalPricesByYearAndGrade(year, gradeId);
    }

    @PostMapping
    public PersonalPrice createAcademicYearPersonalPrice(@RequestBody PersonalPrice academicYearPersonalPrice) {
        return academicYearPersonalPriceService.createAcademicYearPersonalPrice(academicYearPersonalPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalPrice> updateAcademicYearPersonalPrice(@PathVariable Long id, @RequestBody PersonalPrice academicYearPersonalPrice) {
        return ResponseEntity.ok(academicYearPersonalPriceService.updateAcademicYearPersonalPrice(id, academicYearPersonalPrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYearPersonalPrice(@PathVariable Long id) {
        academicYearPersonalPriceService.deleteAcademicYearPersonalPrice(id);
        return ResponseEntity.noContent().build();
    }
}
