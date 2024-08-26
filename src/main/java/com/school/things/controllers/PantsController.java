package com.school.things.controllers;

import com.school.things.entities.items.Pants;
import com.school.things.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pants")
public class PantsController {

    @Autowired
    private ThingService thingService;

    @GetMapping
    public List<Pants> getAllPants() {
        return thingService.getAllPants();
    }

    @GetMapping("/{id}")
    public Optional<Pants> getPantsById(@PathVariable Long id) {
        return thingService.getPantsById(id);
    }

    @PostMapping
    public Pants createPants(@RequestBody Pants pants) {
        return thingService.savePants(pants);
    }

    @PutMapping("/{id}")
    public Pants updatePants(@PathVariable Long id, @RequestBody Pants pants) {
        return thingService.updatePants(id, pants);
    }

    @DeleteMapping("/{id}")
    public void deletePants(@PathVariable Long id) {
        thingService.deletePants(id);
    }
}
