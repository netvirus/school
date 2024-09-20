package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasePriceService {

    @Autowired
    private BasePriceRepository basePriceRepository;

    public List<BasePrice> getAllBasePrices() {
        return basePriceRepository.findAll();
    }

    public Optional<BasePrice> getBasePriceById(Long id) {
        return basePriceRepository.findById(id);
    }

    public BasePrice createBasePrice(BasePrice basePrice) {
        return basePriceRepository.save(basePrice);
    }

    public BasePrice updateBasePrice(Long id, BasePrice updatedBasePrice) {
        return basePriceRepository.findById(id).map(existingBasePrice -> {
            existingBasePrice.setPrices(updatedBasePrice.getPrices());
            existingBasePrice.setPaymentItem(updatedBasePrice.getPaymentItem());
            existingBasePrice.setGrade(updatedBasePrice.getGrade());
            existingBasePrice.setPaymentItemPrice(updatedBasePrice.getPaymentItemPrice());
            return basePriceRepository.save(existingBasePrice);
        }).orElseThrow(() -> new RuntimeException("BasePrice not found for id " + id));
    }

    public boolean deleteBasePrice(Long id) {
        if (basePriceRepository.existsById(id)) {
            basePriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
