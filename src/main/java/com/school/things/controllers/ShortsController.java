package com.school.things.controllers;

import com.school.things.entities.items.Shorts;
import com.school.things.services.ShortsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shorts")
public class ShortsController {

    @Autowired
    private ShortsService shortsService;

    @GetMapping
    public List<Shorts> getAllShorts() {
        return shortsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Shorts> getShortsById(@PathVariable Long id) {
        return shortsService.getById(id);
    }

    @PostMapping
    public Shorts createShorts(@RequestBody Shorts shorts) {
        return shortsService.save(shorts);
    }

    @PutMapping("/{id}")
    public Shorts updateShorts(@PathVariable Long id, @RequestBody Shorts shorts) {
        return shortsService.update(id, shorts);
    }

    @DeleteMapping("/{id}")
    public void deleteShorts(@PathVariable Long id) {
        shortsService.delete(id);
    }
}
