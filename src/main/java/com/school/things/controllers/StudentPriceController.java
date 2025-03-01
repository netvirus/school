package com.school.things.controllers;

import com.school.things.dto.student.StudentPriceDTO;
import com.school.things.dto.student.requests.StudentPriceRequest;
import com.school.things.entities.student.StudentPrice;
import com.school.things.services.StudentPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/prices")
public class StudentPriceController {

    @Autowired
    private StudentPriceService studentPriceService;

    @GetMapping
    public List<StudentPrice> getAllStudentPrices() {
        return studentPriceService.getAllStudentPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentPriceDTO> getStudentPriceById(@PathVariable Long id) {
        StudentPriceDTO studentPriceDTO = studentPriceService.getStudentPriceById(id);
        return ResponseEntity.ok(studentPriceDTO);
    }

    @PostMapping
    public ResponseEntity<StudentPrice> createStudentPrice(@RequestBody StudentPriceRequest request) {
        StudentPrice studentPrice = studentPriceService.createStudentPrice(
                request.getStudentId(),
                request.getGradeId()
        );
        return ResponseEntity.ok(studentPrice);
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
