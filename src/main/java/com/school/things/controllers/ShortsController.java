package com.school.things.controllers;

import com.school.things.entities.items.Shorts;
import com.school.things.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shorts")
public class ShortsController {

    @Autowired
    private ThingService thingService;

    @GetMapping
    public List<Shorts> getAllShorts() {
        return thingService.getAllShorts();
    }

    @GetMapping("/{id}")
    public Optional<Shorts> getShortsById(@PathVariable Long id) {
        return thingService.getShortsById(id);
    }

    @PostMapping
    public Shorts createShorts(@RequestBody Shorts shorts) {
        return thingService.saveShorts(shorts);
    }

    @PutMapping("/{id}")
    public Shorts updateShorts(@PathVariable Long id, @RequestBody Shorts shorts) {
        return thingService.updateShorts(id, shorts);
    }

    @DeleteMapping("/{id}")
    public void deleteShorts(@PathVariable Long id) {
        thingService.deleteShorts(id);
    }
}
