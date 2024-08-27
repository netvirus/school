package com.school.things.services;

import com.school.things.entities.items.Shirt;
import com.school.things.repositories.ShirtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtService extends GenericService<Shirt, Long> {

    private final ShirtRepository shirtRepository;

    public ShirtService(ShirtRepository shirtRepository) {
        super(shirtRepository);
        this.shirtRepository = shirtRepository;
    }

    @Override
    protected void copyProperties(Shirt existingShirt, Shirt updatedShirt) {
        existingShirt.setName(updatedShirt.getName());
        existingShirt.setColor(updatedShirt.getColor());
        existingShirt.setSize(updatedShirt.getSize());
    }

    public List<Shirt> findByColor(String color) {
        return shirtRepository.findByColor(color);
    }
}
