package com.school.things.services;

import com.school.things.entities.pricelist.Prices;
import com.school.things.repositories.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    public List<Prices> getAllPrices() {
        return pricesRepository.findAll();
    }

    public Optional<Prices> getPriceById(Long id) {
        return pricesRepository.findById(id);
    }

    public Prices createPrice(Prices prices) {
        return pricesRepository.save(prices);
    }

    public Prices updatePrice(Long id, Prices updatedPrices) {
        return pricesRepository.findById(id).map(existingPrices -> {
            existingPrices.setPriceYear(updatedPrices.getPriceYear());
            existingPrices.setDescription(updatedPrices.getDescription());
            existingPrices.setBasePrice(updatedPrices.getBasePrice());
            return pricesRepository.save(existingPrices);
        }).orElseThrow(() -> new RuntimeException("Price not found for id " + id));
    }

    public boolean deletePrice(Long id) {
        if (pricesRepository.existsById(id)) {
            pricesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
