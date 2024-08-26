package com.school.things.controllers;

import com.school.things.entities.items.Skirt;
import com.school.things.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skirts")
public class SkirtController {

    @Autowired
    private ThingService thingService;

    @GetMapping
    public List<Skirt> getAllSkirts() {
        return thingService.getAllSkirts();
    }

    @GetMapping("/{id}")
    public Optional<Skirt> getSkirtById(@PathVariable Long id) {
        return thingService.getSkirtById(id);
    }

    @PostMapping
    public Skirt createSkirt(@RequestBody Skirt skirt) {
        return thingService.saveSkirt(skirt);
    }

    @PutMapping("/{id}")
    public Skirt updateSkirt(@PathVariable Long id, @RequestBody Skirt skirt) {
        return thingService.updateSkirt(id, skirt);
    }

    @DeleteMapping("/{id}")
    public void deleteSkirt(@PathVariable Long id) {
        thingService.deleteSkirt(id);
    }
}
