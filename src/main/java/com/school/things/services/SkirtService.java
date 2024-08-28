package com.school.things.services;

import com.school.things.entities.items.Skirt;
import com.school.things.repositories.SkirtRepository;
import org.springframework.stereotype.Service;

@Service
public class SkirtService extends GenericThingsService<Skirt, Long> {

    private final SkirtRepository skirtRepository;

    public SkirtService(SkirtRepository skirtRepository) {
        super(skirtRepository);
        this.skirtRepository = skirtRepository;
    }

    @Override
    protected void copyProperties(Skirt existingSkirt, Skirt updatedSkirt) {
        existingSkirt.setName(updatedSkirt.getName());
        existingSkirt.setColor(updatedSkirt.getColor());
        existingSkirt.setSize(updatedSkirt.getSize());
    }
}
