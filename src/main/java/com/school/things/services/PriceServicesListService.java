package com.school.things.services;

import com.school.things.entities.school.PriceServicesList;
import com.school.things.repositories.PriceServicesListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServicesListService {

    @Autowired
    private PriceServicesListRepository priceServicesListRepository;

    public List<PriceServicesList> getAllServicesLists() {
        return priceServicesListRepository.findAll();
    }

    public Optional<PriceServicesList> getPriceServiceListById(Long id) {
        return priceServicesListRepository.findById(id);
    }

    public PriceServicesList createPriceServiceList(PriceServicesList priceServicesList) {
        return priceServicesListRepository.save(priceServicesList);
    }

    public PriceServicesList updatePriceServiceList(Long id, PriceServicesList updatedPriceServicesList) {
        return priceServicesListRepository.findById(id).map(existingPriceServicesList -> {
            existingPriceServicesList.setPrice(updatedPriceServicesList.getPrice());
            existingPriceServicesList.setSchoolServicesList(updatedPriceServicesList.getSchoolServicesList());
            existingPriceServicesList.setServiceCost(updatedPriceServicesList.getServiceCost());
            return priceServicesListRepository.save(existingPriceServicesList);
        }).orElseThrow(() -> new RuntimeException("Price Services List isn't found by id " + id));
    }

    public boolean deletePriceServiceList(Long id) {
        if (priceServicesListRepository.existsById(id)) {
            priceServicesListRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
