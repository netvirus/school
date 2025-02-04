package com.school.things.services;

import com.school.things.entities.price.Price;
import com.school.things.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Optional<Price> getPriceById(Long id) {
        return priceRepository.findById(id);
    }

    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }

    public Price updatePrice(Price price, Long id) {
        return priceRepository.findById(id)
                .map(existingPrice -> {
                    existingPrice.setName(price.getName());
                    return priceRepository.save(existingPrice);
                })
                .orElseThrow(() -> new RuntimeException("Price not found"));
    }

    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }
}
