package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.entities.pricelist.Prices;
import com.school.things.repositories.BasePriceRepository;
import com.school.things.repositories.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PricesService {

    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private BasePriceRepository basePriceRepository;

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

    @Transactional
    public Prices createAndClonePrices(Long previousPriceId, int newPriceYear) {
        Optional<Prices> previousPricesOpt = pricesRepository.findById(previousPriceId);
        if (previousPricesOpt.isEmpty()) {
            throw new RuntimeException("Previous Price not found for id " + previousPriceId);
        }

        Prices previousPrices = previousPricesOpt.get();
        Prices newPrices = new Prices(newPriceYear, previousPrices.getDescription());
        newPrices = pricesRepository.save(newPrices);

        List<BasePrice> previousBasePrices = basePriceRepository.findByPrices(previousPrices);

//        for (BasePrice previousBasePrice : previousBasePrices) {
//            BasePrice newBasePrice = new BasePrice(
//                    newPrices,
//                    previousBasePrice.getPaymentItem(),
//                    previousBasePrice.getGrade(),
//                    previousBasePrice.getPaymentItemPrice()
//            );
//            basePriceRepository.save(newBasePrice);
//        }
        return newPrices;
    }
}
