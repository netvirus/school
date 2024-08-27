package com.school.things.controllers;

import com.school.things.entities.items.Pants;
import com.school.things.services.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pants")
public class PantsController {

    @Autowired
    private PantsService pantsService;

    @GetMapping
    public List<Pants> getAllPants() {
        return pantsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pants> getPantsById(@PathVariable Long id) {
        return pantsService.getById(id);
    }

    @PostMapping
    public Pants createPants(@RequestBody Pants pants) {
        return pantsService.save(pants);
    }

    @PutMapping("/{id}")
    public Pants updatePants(@PathVariable Long id, @RequestBody Pants pants) {
        return pantsService.update(id, pants);
    }

    @DeleteMapping("/{id}")
    public void deletePants(@PathVariable Long id) {
        pantsService.delete(id);
    }
}
