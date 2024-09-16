package com.school.things.controllers;

import com.school.things.entities.pricelist.AcademicYearBasePrice;
import com.school.things.services.AcademicYearBasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academic-year-base-prices")
public class AcademicYearBasePriceController {

    @Autowired
    private AcademicYearBasePriceService academicYearBasePriceService;

    // Получить все записи
    @GetMapping
    public List<AcademicYearBasePrice> getAllPrices() {
        return academicYearBasePriceService.getAllPrices();
    }

    // Получить запись по ID
    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearBasePrice> getPriceById(@PathVariable Long id) {
        AcademicYearBasePrice price = academicYearBasePriceService.getPriceById(id);
        return ResponseEntity.ok(price);
    }

    // Получить записи по gradeId
    @GetMapping("/grade/{gradeId}")
    public ResponseEntity<List<AcademicYearBasePrice>> getPricesByGradeId(@PathVariable Long gradeId) {
        List<AcademicYearBasePrice> prices = academicYearBasePriceService.getPricesByGradeId(gradeId);
        return ResponseEntity.ok(prices);
    }

    // Создать новую запись
    @PostMapping
    public ResponseEntity<AcademicYearBasePrice> createPrice(@RequestBody AcademicYearBasePrice academicYearBasePrice) {
        AcademicYearBasePrice createdPrice = academicYearBasePriceService.createAcademicYearBasePrice(academicYearBasePrice);
        return ResponseEntity.ok(createdPrice);
    }

    // Обновить запись
    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearBasePrice> updatePrice(@PathVariable Long id, @RequestBody AcademicYearBasePrice academicYearBasePrice) {
        AcademicYearBasePrice updatedPrice = academicYearBasePriceService.updateAcademicYearBasePrice(id, academicYearBasePrice);
        return ResponseEntity.ok(updatedPrice);
    }

    // Удалить запись
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        boolean deleted = academicYearBasePriceService.deleteAcademicYearBasePrice(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
