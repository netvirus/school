package com.school.things.controllers;

import com.school.things.entities.school.Price;
import com.school.things.entities.student.Student;
import com.school.things.services.PriceService;
import com.school.things.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<List<Price>> getAllStudents() {
        List<Price> prices = priceService.getAllPrices();
        return ResponseEntity.ok(prices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long id) {
        Optional<Price> price = priceService.getPriceById(id);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Price> createStudent(@RequestBody Price price) {
        Price createdPrice = priceService.savePrice(price);
        return ResponseEntity.ok(createdPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, @RequestBody Price price) {
        Price updatedPrice = priceService.updatePrice(price, id);
        return ResponseEntity.ok(updatedPrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
        return ResponseEntity.noContent().build();
    }
}
