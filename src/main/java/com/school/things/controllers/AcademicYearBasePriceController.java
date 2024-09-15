package com.school.things.controllers;

import com.school.things.entities.pricelist.AcademicYearBasePrice;
import com.school.things.services.AcademicYearBasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/academic-year-base-prices")
public class AcademicYearBasePriceController {

    @Autowired
    private AcademicYearBasePriceService academicYearBasePriceService;

    @GetMapping
    public List<AcademicYearBasePrice> getAllAcademicYearBasePrices() {
        return academicYearBasePriceService.getAllAcademicYearBasePrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearBasePrice> getAcademicYearBasePriceById(@PathVariable Long id) {
        Optional<AcademicYearBasePrice> academicYearBasePrice = academicYearBasePriceService.getAcademicYearBasePriceById(id);
        return academicYearBasePrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/year/{year}")
    public List<AcademicYearBasePrice> getAcademicYearBasePricesByYear(@PathVariable int year) {
        return academicYearBasePriceService.getAcademicYearBasePricesByYear(year);
    }

    @PostMapping
    public AcademicYearBasePrice createAcademicYearBasePrice(@RequestBody AcademicYearBasePrice academicYearBasePrice) {
        return academicYearBasePriceService.createAcademicYearBasePrice(academicYearBasePrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearBasePrice> updateAcademicYearBasePrice(@PathVariable Long id, @RequestBody AcademicYearBasePrice academicYearBasePrice) {
        return ResponseEntity.ok(academicYearBasePriceService.updateAcademicYearBasePrice(id, academicYearBasePrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYearBasePrice(@PathVariable Long id) {
        academicYearBasePriceService.deleteAcademicYearBasePrice(id);
        return ResponseEntity.noContent().build();
    }
}
