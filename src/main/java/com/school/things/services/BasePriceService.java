package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasePriceService {

    private static final Logger log = LoggerFactory.getLogger(BasePriceService.class);

    @Autowired
    private BasePriceRepository basePriceRepository;

    public List<BasePrice> getAllPrices() {
        List<Object[]> results = basePriceRepository.findAllWithPaymentItemNameAndGrade();
        List<BasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            BasePrice price = new BasePrice();

            // Безопасное приведение через Number для числовых значений
            if (result[0] != null) price.setId(((Number) result[0]).longValue());
            if (result[1] != null) price.setPaymentItemId(((Number) result[1]).longValue());
            if (result[2] != null) price.setPaymentItemPrice((Double) result[2]);
            if (result[3] != null) price.setPriceYear((Integer) result[3]);
            if (result[4] != null) price.setPaymentItemName((String) result[4]);
            if (result[5] != null) price.setGradeName((String) result[5]);

            prices.add(price);
        }
        log.info("Fetched {} BasePrice records", prices.size());
        return prices;
    }

    public BasePrice getPriceById(Long id) {
        Object[] result = basePriceRepository.findByIdWithPaymentItemNameAndGrade(id);

        if (result == null) {
            log.warn("BasePrice not found for id {}", id);
            throw new RuntimeException("BasePrice not found for id " + id);
        }

        BasePrice price = new BasePrice();

        if (result[0] != null) price.setId(((Number) result[0]).longValue());
        if (result[1] != null) price.setPaymentItemId(((Number) result[1]).longValue());
        if (result[2] != null) price.setPaymentItemPrice((Double) result[2]);
        if (result[3] != null) price.setPriceYear((Integer) result[3]);
        if (result[4] != null) price.setPaymentItemName((String) result[4]);
        if (result[5] != null) price.setGradeName((String) result[5]);

        log.info("Fetched BasePrice with id {}", id);
        return price;
    }

    public BasePrice createBasePrice(BasePrice academicYearBasePrice) {
        log.info("Creating BasePrice for year: {}, paymentItemId: {}, gradeId: {}",
                academicYearBasePrice.getPriceYear(), academicYearBasePrice.getPaymentItemId(), academicYearBasePrice.getGradeId());
        return basePriceRepository.save(academicYearBasePrice);
    }

    public BasePrice updateBasePrice(Long id, BasePrice basePrice) {
        return basePriceRepository.findById(id)
                .map(existingBasePrice -> {
                    existingBasePrice.setPriceYear(basePrice.getPriceYear());
                    existingBasePrice.setPaymentItemId(basePrice.getPaymentItemId());
                    existingBasePrice.setPaymentItemPrice(basePrice.getPaymentItemPrice());
                    existingBasePrice.setGradeId(basePrice.getGradeId());

                    log.info("Updating BasePrice with id {}, new year: {}, paymentItemId: {}, gradeId: {}",
                            id, basePrice.getPriceYear(), basePrice.getPaymentItemId(), basePrice.getGradeId());

                    return basePriceRepository.save(existingBasePrice);
                })
                .orElseThrow(() -> {
                    log.error("BasePrice not found for id {}", id);
                    return new RuntimeException("BasePrice not found for id " + id);
                });
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
