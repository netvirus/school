package com.school.things.controllers;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.services.BasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academic-year-base-prices")
public class BasePriceController {

    @Autowired
    private BasePriceService academicYearBasePriceService;

    // Получить все записи
    @GetMapping
    public List<BasePrice> getAllPrices() {
        return academicYearBasePriceService.getAllPrices();
    }

    // Получить запись по ID
    @GetMapping("/{id}")
    public ResponseEntity<BasePrice> getPriceById(@PathVariable Long id) {
        BasePrice price = academicYearBasePriceService.getPriceById(id);
        return ResponseEntity.ok(price);
    }

    // Получить записи по gradeId
    @GetMapping("/grade/{gradeId}")
    public ResponseEntity<List<BasePrice>> getPricesByGradeId(@PathVariable Long gradeId) {
        List<BasePrice> prices = academicYearBasePriceService.getPricesByGradeId(gradeId);
        return ResponseEntity.ok(prices);
    }

    // Создать новую запись
    @PostMapping
    public ResponseEntity<BasePrice> createPrice(@RequestBody BasePrice academicYearBasePrice) {
        BasePrice createdPrice = academicYearBasePriceService.createAcademicYearBasePrice(academicYearBasePrice);
        return ResponseEntity.ok(createdPrice);
    }

    // Обновить запись
    @PutMapping("/{id}")
    public ResponseEntity<BasePrice> updatePrice(@PathVariable Long id, @RequestBody BasePrice academicYearBasePrice) {
        BasePrice updatedPrice = academicYearBasePriceService.updateAcademicYearBasePrice(id, academicYearBasePrice);
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
