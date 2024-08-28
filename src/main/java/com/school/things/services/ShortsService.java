package com.school.things.services;

import com.school.things.entities.items.Shorts;
import com.school.things.repositories.ShortsRepository;
import org.springframework.stereotype.Service;

@Service
public class ShortsService extends GenericThingsService<Shorts, Long> {

    private final ShortsRepository shortsRepository;

    public ShortsService(ShortsRepository shortsRepository) {
        super(shortsRepository);
        this.shortsRepository = shortsRepository;
    }

    @Override
    protected void copyProperties(Shorts existingShorts, Shorts updatedShorts) {
        existingShorts.setName(updatedShorts.getName());
        existingShorts.setColor(updatedShorts.getColor());
        existingShorts.setSize(updatedShorts.getSize());
    }
}
