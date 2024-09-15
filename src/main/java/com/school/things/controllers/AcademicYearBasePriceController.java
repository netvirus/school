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

    // Получить все записи с учётом paymentItemName
    @GetMapping
    public ResponseEntity<List<AcademicYearBasePrice>> getAllAcademicYearBasePrices() {
        List<AcademicYearBasePrice> prices = academicYearBasePriceService.getAllPrices();
        return ResponseEntity.ok(prices);
    }

    // Получить конкретную запись по id с учётом paymentItemName
    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearBasePrice> getAcademicYearBasePriceById(@PathVariable Long id) {
        AcademicYearBasePrice price = academicYearBasePriceService.getPriceById(id);
        if (price == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(price);
    }

    // Создание новой записи
    @PostMapping
    public ResponseEntity<AcademicYearBasePrice> createAcademicYearBasePrice(@RequestBody AcademicYearBasePrice price) {
        AcademicYearBasePrice createdPrice = academicYearBasePriceService.createAcademicYearBasePrice(price);
        return ResponseEntity.ok(createdPrice);
    }

    // Обновление записи
    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearBasePrice> updateAcademicYearBasePrice(@PathVariable Long id, @RequestBody AcademicYearBasePrice price) {
        AcademicYearBasePrice updatedPrice = academicYearBasePriceService.updateAcademicYearBasePrice(id, price);
        if (updatedPrice == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYearBasePrice(@PathVariable Long id) {
        boolean isDeleted = academicYearBasePriceService.deleteAcademicYearBasePrice(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
