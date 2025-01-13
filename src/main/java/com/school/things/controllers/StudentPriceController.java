package com.school.things.controllers;

import com.school.things.entities.student.StudentPrice;
import com.school.things.services.StudentPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personal-prices")
public class StudentPriceController {

    @Autowired
    private StudentPriceService studentPriceService;

    @GetMapping
    public List<StudentPrice> getAllStudentPrices() {
        return studentPriceService.getAllStudentPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentPrice> getStudentPriceById(@PathVariable Long id) {
        Optional<StudentPrice> studentPrice = studentPriceService.getStudentPriceById(id);
        return studentPrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentPrice createStudentPrice(@RequestBody StudentPrice studentPrice) {
        return studentPriceService.createStudentPrice(studentPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentPrice> updateStudentPrice(@PathVariable Long id, @RequestBody StudentPrice studentPrice) {
        return ResponseEntity.ok(studentPriceService.updateStudentPrice(id, studentPrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentPrice(@PathVariable Long id) {
        studentPriceService.deleteStudentPrice(id);
        return ResponseEntity.noContent().build();
    }
}
