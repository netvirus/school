package com.school.things.controllers;

import com.school.things.entities.student.StudentPrice;
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
    public List<StudentPrice> getAllStudentPersonalPrices() {
        return studentPersonalPriceService.getAllStudentPersonalPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentPrice> getStudentPersonalPriceById(@PathVariable Long id) {
        Optional<StudentPrice> studentPersonalPrice = studentPersonalPriceService.getStudentPersonalPriceById(id);
        return studentPersonalPrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentPrice createStudentPersonalPrice(@RequestBody StudentPrice studentPrice) {
        return studentPersonalPriceService.createStudentPersonalPrice(studentPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentPrice> updateStudentPersonalPrice(@PathVariable Long id, @RequestBody StudentPrice studentPrice) {
        return ResponseEntity.ok(studentPersonalPriceService.updateStudentPersonalPrice(id, studentPrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentPersonalPrice(@PathVariable Long id) {
        studentPersonalPriceService.deleteStudentPersonalPrice(id);
        return ResponseEntity.noContent().build();
    }
}
