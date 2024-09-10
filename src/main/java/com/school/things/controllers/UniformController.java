package com.school.things.controllers;

import com.school.things.entities.Book;
import com.school.things.entities.Uniform;
import com.school.things.services.UniformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/uniform")
public class UniformController {

    @Autowired
    private UniformService uniformService;

    @GetMapping
    public List<Uniform> getAllUniform() {
        return uniformService.getAllUniform();
    }

    @GetMapping("/{id}")
    public Optional<Uniform> getUniformById(@PathVariable Long id) {
        return uniformService.getUniformById(id);
    }

    @PostMapping
    public Uniform createUniform(@RequestBody Uniform uniform) {
        return uniformService.saveUniform(uniform);
    }

    @PutMapping("/{id}")
    public Uniform updateUniform(@PathVariable Long id, @RequestBody Uniform uniform) {
        return uniformService.updateUniform(id, uniform);
    }

    @DeleteMapping("/{id}")
    public void uniformService(@PathVariable Long id) {
        uniformService.deleteUniform(id);
    }
}
