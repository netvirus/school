package com.school.things.controllers;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.services.BasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/base-prices")
public class BasePriceController {

    @Autowired
    private BasePriceService basePriceService;

    // Получить все записи
    @GetMapping
    public List<BasePrice> getAllPrices() {
        return basePriceService.getAllPrices();
    }

    // Получить запись по ID
    @GetMapping("/{id}")
    public ResponseEntity<BasePrice> getPriceById(@PathVariable Long id) {
        BasePrice price = basePriceService.getPriceById(id);
        return ResponseEntity.ok(price);
    }

    // Создать новую запись
    @PostMapping
    public ResponseEntity<BasePrice> createPrice(@RequestBody BasePrice basePrice) {
        BasePrice createdPrice = basePriceService.createBasePrice(basePrice);
        return ResponseEntity.ok(createdPrice);
    }

    // Обновить запись
    @PutMapping("/{id}")
    public ResponseEntity<BasePrice> updatePrice(@PathVariable Long id, @RequestBody BasePrice BasePrice) {
        BasePrice updatedPrice = basePriceService.updateBasePrice(id, BasePrice);
        return ResponseEntity.ok(updatedPrice);
    }

    // Удалить запись
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        boolean deleted = basePriceService.deleteBasePrice(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
