package com.school.things.controllers;

import com.school.things.entities.items.Skirt;
import com.school.things.services.SkirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skirts")
public class SkirtController {

    @Autowired
    private SkirtService skirtService;

    @GetMapping
    public List<Skirt> getAllSkirts() {
        return skirtService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Skirt> getSkirtById(@PathVariable Long id) {
        return skirtService.getById(id);
    }

    @PostMapping
    public Skirt createSkirt(@RequestBody Skirt skirt) {
        return skirtService.save(skirt);
    }

    @PutMapping("/{id}")
    public Skirt updateSkirt(@PathVariable Long id, @RequestBody Skirt skirt) {
        return skirtService.update(id, skirt);
    }

    @DeleteMapping("/{id}")
    public void deleteSkirt(@PathVariable Long id) {
        skirtService.delete(id);
    }
}
