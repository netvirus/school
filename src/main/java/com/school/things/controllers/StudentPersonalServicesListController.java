package com.school.things.controllers;

import com.school.things.entities.student.StudentDiscount;
import com.school.things.services.StudentPersonalServicesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personal-services")
public class StudentPersonalServicesListController {

    @Autowired
    private StudentPersonalServicesListService studentPersonalServicesListService;

    @GetMapping
    public List<StudentDiscount> getAllStudentPersonalServicesList() {
        return studentPersonalServicesListService.getAllStudentPersonalServicesList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDiscount> getStudentPersonalServicesListById(@PathVariable Long id) {
        Optional<StudentDiscount> price = studentPersonalServicesListService.getStudentPersonalServicesListById(id);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentDiscount> createStudentPersonalServicesList(@RequestBody StudentDiscount studentPersonalPrice) {
        StudentDiscount createdPrice = studentPersonalServicesListService.createStudentPersonalServicesList(studentPersonalPrice);
        return ResponseEntity.ok(createdPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDiscount> updateStudentPersonalServicesList(@PathVariable Long id, @RequestBody StudentDiscount studentPersonalPrice) {
        StudentDiscount updatedPrice = studentPersonalServicesListService.updateStudentPersonalServicesList(id, studentPersonalPrice);
        return ResponseEntity.ok(updatedPrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentPersonalServicesList(@PathVariable Long id) {
        boolean deleted = studentPersonalServicesListService.deleteStudentPersonalServicesList(id);
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
