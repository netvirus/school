package com.school.things.controllers;

import com.school.things.entities.pricelist.PersonalDiscount;
import com.school.things.services.PersonalDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personal-discounts")
public class PersonalDiscountController {

    @Autowired
    private PersonalDiscountService personalDiscountService;

    @GetMapping
    public List<PersonalDiscount> getAllDiscounts() {
        return personalDiscountService.getAllPersonalDiscounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalDiscount> getDiscountById(@PathVariable Long id) {
        Optional<PersonalDiscount> discount = personalDiscountService.getDiscountById(id);
        return discount.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<PersonalDiscount> getDiscountByStudentId(@PathVariable Long studentId) {
        Optional<PersonalDiscount> discount = personalDiscountService.getDiscountByStudentId(studentId);
        return discount.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PersonalDiscount createDiscount(@RequestBody PersonalDiscount personalDiscount) {
        return personalDiscountService.savePersonalDiscount(personalDiscount);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable Long id) {
        personalDiscountService.deletePersonalDiscount(id);
    }
}
