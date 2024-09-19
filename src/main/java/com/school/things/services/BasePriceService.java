package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class BasePriceService {

    private static final Logger log = LoggerFactory.getLogger(BasePriceService.class);

    @Autowired
    private BasePriceRepository basePriceRepository;

    public List<BasePrice> getAllPrices() {
        List<BasePrice> prices = basePriceRepository.findAllWithPaymentItemAndGrade();
        log.info("Fetched {} BasePrice records", prices.size());
        return prices;
    }

    public BasePrice getPriceById(Long id) {
        BasePrice price = basePriceRepository.findByIdWithPaymentItemAndGrade(id);

        if (price == null) {
            log.warn("BasePrice not found for id {}", id);
            throw new RuntimeException("BasePrice not found for id " + id);
        }

        log.info("Fetched BasePrice with id {}", id);
        return price;
    }

    public BasePrice createBasePrice(BasePrice basePrice) {
        log.info("Creating BasePrice for year: {}, paymentItemId: {}, gradeId: {}",
                basePrice.getPriceYear(), basePrice.getPaymentItem().getId(), basePrice.getGrade().getId());
        return basePriceRepository.save(basePrice);
    }

    public BasePrice updateBasePrice(Long id, BasePrice basePrice) {
        return basePriceRepository.findById(id)
                .map(existingBasePrice -> {
                    updateExistingPrice(existingBasePrice, basePrice);
                    log.info("Updating BasePrice with id {}, new year: {}, paymentItemId: {}, gradeId: {}",
                            id, basePrice.getPriceYear(), basePrice.getPaymentItem().getId(), basePrice.getGrade().getId());
                    return basePriceRepository.save(existingBasePrice);
                })
                .orElseThrow(() -> {
                    log.error("BasePrice not found for id {}", id);
                    return new RuntimeException("BasePrice not found for id " + id);
                });
    }

    private void updateExistingPrice(BasePrice existing, BasePrice updated) {
        existing.setPriceYear(updated.getPriceYear());
        existing.setPaymentItemPrice(updated.getPaymentItemPrice());
        existing.setGrade(updated.getGrade());
        existing.setPaymentItem(updated.getPaymentItem());
    }

    public boolean deleteBasePrice(Long id) {
        if (basePriceRepository.existsById(id)) {
            basePriceRepository.deleteById(id);
            log.info("Deleted BasePrice with id {}", id);
            return true;
        } else {
            log.warn("Attempted to delete non-existent BasePrice with id {}", id);
            return false;
        }
    }
}
