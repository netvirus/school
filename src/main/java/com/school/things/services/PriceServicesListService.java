package com.school.things.services;

import com.school.things.entities.school.PriceServiceList;
import com.school.things.repositories.PriceServiceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServicesListService {

    @Autowired
    private PriceServiceListRepository priceServiceListRepository;

    public List<PriceServiceList> getAllServicesLists() {
        return priceServiceListRepository.findAll();
    }

    public Optional<PriceServiceList> getPriceServiceListById(Long id) {
        return priceServiceListRepository.findById(id);
    }

    public PriceServiceList createPriceServiceList(PriceServiceList priceServiceList) {
        return priceServiceListRepository.save(priceServiceList);
    }

    public PriceServiceList updatePriceServiceList(Long id, PriceServiceList updatedPriceServiceList) {
        return priceServiceListRepository.findById(id).map(existingPriceServiceList -> {
            existingPriceServiceList.setPrice(updatedPriceServiceList.getPrice());
            existingPriceServiceList.setSchoolServiceList(updatedPriceServiceList.getSchoolServiceList());
            existingPriceServiceList.setCost(updatedPriceServiceList.getCost());
            return priceServiceListRepository.save(existingPriceServiceList);
        }).orElseThrow(() -> new RuntimeException("Price Services List isn't found by id " + id));
    }

    public boolean deletePriceServiceList(Long id) {
        if (priceServiceListRepository.existsById(id)) {
            priceServiceListRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
