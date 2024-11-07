package com.school.things.controllers;

import com.school.things.entities.prices.StudentPersonalPrice;
import com.school.things.services.StudentPersonalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personal-prices")
public class StudentPersonalPriceController {

    @Autowired
    private StudentPersonalPriceService studentPersonalPriceService;

    @GetMapping
    public List<StudentPersonalPrice> getAllStudentPersonalPrices() {
        return studentPersonalPriceService.getAllStudentPersonalPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentPersonalPrice> getStudentPersonalPriceById(@PathVariable Long id) {
        Optional<StudentPersonalPrice> studentPersonalPrice = studentPersonalPriceService.getStudentPersonalPriceById(id);
        return studentPersonalPrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentPersonalPrice createStudentPersonalPrice(@RequestBody StudentPersonalPrice studentPersonalPrice) {
        return studentPersonalPriceService.createStudentPersonalPrice(studentPersonalPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentPersonalPrice> updateStudentPersonalPrice(@PathVariable Long id, @RequestBody StudentPersonalPrice studentPersonalPrice) {
        return ResponseEntity.ok(studentPersonalPriceService.updateStudentPersonalPrice(id, studentPersonalPrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentPersonalPrice(@PathVariable Long id) {
        studentPersonalPriceService.deleteStudentPersonalPrice(id);
        return ResponseEntity.noContent().build();
    }
}
