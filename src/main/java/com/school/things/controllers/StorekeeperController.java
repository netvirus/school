package com.school.things.controllers;

import com.school.things.entities.Storekeeper;
import com.school.things.services.StorekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/storekeepers")
public class StorekeeperController {

    @Autowired
    private StorekeeperService storekeeperService;

    @GetMapping
    public List<Storekeeper> getAllStorekeepers() {
        return storekeeperService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Storekeeper> getStorekeeperById(@PathVariable Long id) {
        return storekeeperService.getById(id);
    }

    @PostMapping
    public Storekeeper createStorekeeper(@RequestBody Storekeeper storekeeper) {
        return storekeeperService.save(storekeeper);
    }

    @PutMapping("/{id}")
    public Storekeeper updateStorekeeper(@PathVariable Long id, @RequestBody Storekeeper storekeeper) {
        return storekeeperService.update(id, storekeeper);
    }

    @DeleteMapping("/{id}")
    public void deleteStorekeeper(@PathVariable Long id) {
        storekeeperService.delete(id);
    }
}
