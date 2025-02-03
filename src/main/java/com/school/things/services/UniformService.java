package com.school.things.services;

import com.school.things.entities.items.Uniform;
import com.school.things.repositories.UniformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniformService {

    @Autowired
    private UniformRepository uniformRepository;

    public List<Uniform> getAllUniform() {
        return uniformRepository.findAll();
    }

    public Optional<Uniform> getUniformById(Long id) {
        return uniformRepository.findById(id);
    }

    public Uniform saveUniform(Uniform uniform) {
        return uniformRepository.save(uniform);
    }

    public Uniform updateUniform(Long id, Uniform uniform) {
        return uniformRepository.findById(id)
                .map(existingUniform -> {
                    existingUniform.setName(uniform.getName());
                    existingUniform.setColor(uniform.getColor());
                    existingUniform.setSize(uniform.getSize());
                    return uniformRepository.save(existingUniform);
                })
                .orElseThrow(() -> new RuntimeException("Uniform not found"));
    }

    public void deleteUniform(Long id) {
        uniformRepository.deleteById(id);
    }
}
