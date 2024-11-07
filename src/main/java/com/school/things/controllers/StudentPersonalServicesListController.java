package com.school.things.controllers;

import com.school.things.entities.prices.StudentPersonalServicesList;
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
    public List<StudentPersonalServicesList> getAllStudentPersonalServicesList() {
        return studentPersonalServicesListService.getAllStudentPersonalServicesList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentPersonalServicesList> getStudentPersonalServicesListById(@PathVariable Long id) {
        Optional<StudentPersonalServicesList> price = studentPersonalServicesListService.getStudentPersonalServicesListById(id);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentPersonalServicesList> createStudentPersonalServicesList(@RequestBody StudentPersonalServicesList studentPersonalPrice) {
        StudentPersonalServicesList createdPrice = studentPersonalServicesListService.createStudentPersonalServicesList(studentPersonalPrice);
        return ResponseEntity.ok(createdPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentPersonalServicesList> updateStudentPersonalServicesList(@PathVariable Long id, @RequestBody StudentPersonalServicesList studentPersonalPrice) {
        StudentPersonalServicesList updatedPrice = studentPersonalServicesListService.updateStudentPersonalServicesList(id, studentPersonalPrice);
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
