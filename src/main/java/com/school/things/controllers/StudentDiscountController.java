package com.school.things.controllers;

import com.school.things.entities.student.StudentDiscount;
import com.school.things.services.StudentDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student/discount")
public class StudentDiscountController {

    @Autowired
    private StudentDiscountService studentDiscountService;

    @GetMapping
    public List<StudentDiscount> getAllStudentDiscounts() {
        return studentDiscountService.getAllStudentDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDiscount> getStudentDiscountById(@PathVariable Long id) {
        Optional<StudentDiscount> price = studentDiscountService.getStudentDiscountById(id);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentDiscount> createStudentDiscount(@RequestBody StudentDiscount studentDiscount) {
        StudentDiscount createdDiscount = studentDiscountService.createStudentDiscount(studentDiscount);
        return ResponseEntity.ok(createdDiscount);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDiscount> updateStudentDiscount(@PathVariable Long id, @RequestBody StudentDiscount studentDiscount) {
        StudentDiscount updatedDiscount = studentDiscountService.updateStudentDiscount(id, studentDiscount);
        return ResponseEntity.ok(updatedDiscount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentDiscount(@PathVariable Long id) {
        boolean deleted = studentDiscountService.deleteStudentDiscount(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/create-and-clone")
//    public ResponseEntity<StudentPersonalPrice> createAndClonePrices(@RequestParam Long previousPriceId, @RequestParam int newPriceYear) {
//        StudentPersonalPrice newStudentPersonalPrice = studentPersonalServicesListService.createAndClonePrices(previousPriceId, newPriceYear);
//        return ResponseEntity.ok(newStudentPersonalPrice);
//    }
}
