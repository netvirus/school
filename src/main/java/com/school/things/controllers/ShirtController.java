package com.school.things.controllers;

import com.school.things.entities.items.Shirt;
import com.school.things.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shirts")
public class ShirtController {

    @Autowired
    private ThingService thingService;

    @GetMapping
    public List<Shirt> getAllShirts() {
        return thingService.getAllShirts();
    }

    @GetMapping("/{id}")
    public Optional<Shirt> getShirtById(@PathVariable Long id) {
        return thingService.getShirtById(id);
    }

    @PostMapping
    public Shirt createShirt(@RequestBody Shirt shirt) {
        return thingService.saveShirt(shirt);
    }

    @PutMapping("/{id}")
    public Shirt updateShirt(@PathVariable Long id, @RequestBody Shirt shirt) {
        return thingService.updateShirt(id, shirt);
    }

    @DeleteMapping("/{id}")
    public void deleteShirt(@PathVariable Long id) {
        thingService.deleteShirt(id);
    }
}
