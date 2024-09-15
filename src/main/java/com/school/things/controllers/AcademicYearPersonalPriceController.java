package com.school.things.controllers;

import com.school.things.entities.pricelist.AcademicYearPersonalPrice;
import com.school.things.services.AcademicYearPersonalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academic-year-personal-prices")
public class AcademicYearPersonalPriceController {

    @Autowired
    private AcademicYearPersonalPriceService academicYearPersonalPriceService;

    @GetMapping
    public List<AcademicYearPersonalPrice> getAllAcademicYearPersonalPrices() {
        return academicYearPersonalPriceService.getAllAcademicYearPersonalPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearPersonalPrice> getAcademicYearPersonalPriceById(@PathVariable Long id) {
        Optional<AcademicYearPersonalPrice> academicYearPersonalPrice = academicYearPersonalPriceService.getAcademicYearPersonalPriceById(id);
        return academicYearPersonalPrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public List<AcademicYearPersonalPrice> getAcademicYearPersonalPricesByStudentId(@PathVariable Long studentId) {
        return academicYearPersonalPriceService.getAcademicYearPersonalPricesByStudentId(studentId);
    }

    @GetMapping("/year/{year}/grade/{gradeId}")
    public List<AcademicYearPersonalPrice> getAcademicYearPersonalPricesByYearAndGrade(@PathVariable int year, @PathVariable int gradeId) {
        return academicYearPersonalPriceService.getAcademicYearPersonalPricesByYearAndGrade(year, gradeId);
    }

    @PostMapping
    public AcademicYearPersonalPrice createAcademicYearPersonalPrice(@RequestBody AcademicYearPersonalPrice academicYearPersonalPrice) {
        return academicYearPersonalPriceService.createAcademicYearPersonalPrice(academicYearPersonalPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearPersonalPrice> updateAcademicYearPersonalPrice(@PathVariable Long id, @RequestBody AcademicYearPersonalPrice academicYearPersonalPrice) {
        return ResponseEntity.ok(academicYearPersonalPriceService.updateAcademicYearPersonalPrice(id, academicYearPersonalPrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYearPersonalPrice(@PathVariable Long id) {
        academicYearPersonalPriceService.deleteAcademicYearPersonalPrice(id);
        return ResponseEntity.noContent().build();
    }
}
