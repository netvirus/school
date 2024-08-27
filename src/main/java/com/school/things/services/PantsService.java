package com.school.things.services;

import com.school.things.entities.items.Pants;
import com.school.things.repositories.PantsRepository;
import org.springframework.stereotype.Service;

@Service
public class PantsService extends GenericService<Pants, Long> {

    private final PantsRepository pantsRepository;

    public PantsService(PantsRepository pantsRepository) {
        super(pantsRepository);
        this.pantsRepository = pantsRepository;
    }

    @Override
    protected void copyProperties(Pants existingPants, Pants updatedPants) {
        existingPants.setName(updatedPants.getName());
        existingPants.setColor(updatedPants.getColor());
        existingPants.setSize(updatedPants.getSize());
    }
}
