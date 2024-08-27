package com.school.things.controllers;

import com.school.things.entities.items.Shirt;
import com.school.things.services.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shirts")
public class ShirtController {

    @Autowired
    private ShirtService shirtService;

    @GetMapping
    public List<Shirt> getAllShirts() {
        return shirtService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Shirt> getShirtById(@PathVariable Long id) {
        return shirtService.getById(id);
    }

    @PostMapping
    public Shirt createShirt(@RequestBody Shirt shirt) {
        return shirtService.save(shirt);
    }

    @PutMapping("/{id}")
    public Shirt updateShirt(@PathVariable Long id, @RequestBody Shirt shirt) {
        return shirtService.update(id, shirt);
    }

    @DeleteMapping("/{id}")
    public void deleteShirt(@PathVariable Long id) {
        shirtService.delete(id);
    }

    // Дополнительный метод для поиска по цвету
    @GetMapping("/color/{color}")
    public ResponseEntity<List<Shirt>> getShirtsByColor(@PathVariable String color) {
        List<Shirt> shirts = shirtService.findByColor(color);
        return ResponseEntity.ok(shirts);
    }
}
