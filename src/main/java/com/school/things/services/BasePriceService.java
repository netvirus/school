package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Service
public class BasePriceService {

    private static final Logger log = LoggerFactory.getLogger(BasePriceService.class);

    @Autowired
    private BasePriceRepository basePriceRepository;

    public List<BasePrice> getAllPrices() {
        List<Object[]> results = basePriceRepository.findAllWithPaymentItemNameAndGrade();
        List<BasePrice> prices = results.stream()
                .map(this::mapToBasePrice)
                .toList(); // Используем Stream API

        log.info("Fetched {} BasePrice records", prices.size());
        return prices;
    }

    public BasePrice getPriceById(Long id) {
        Object[] result = basePriceRepository.findByIdWithPaymentItemNameAndGrade(id);

        if (result == null) {
            log.warn("BasePrice not found for id {}", id);
            throw new RuntimeException("BasePrice not found for id " + id);
        }

        BasePrice price = mapToBasePrice(result);
        log.info("Fetched BasePrice with id {}", id);
        return price;
    }

    private BasePrice mapToBasePrice(Object[] result) {
        if (result == null || result.length < 6) {
            log.error("Invalid result array: {}", (Object) result);
            throw new IllegalArgumentException("Result array is invalid");
        }

        return new BasePrice(
                safeCast(result[0], Number.class).map(Number::longValue).orElse(null),
                safeCast(result[1], Number.class).map(Number::longValue).orElse(null),
                safeCast(result[2], Double.class).orElse(null),
                safeCast(result[3], Integer.class).orElse(null),
                safeCast(result[4], String.class).orElse(null),
                safeCast(result[5], String.class).orElse(null)
        );
    }

    // Используем безопасное приведение типов
    private <T> Optional<T> safeCast(Object obj, Class<T> clazz) {
        if (clazz.isInstance(obj)) {
            return Optional.of(clazz.cast(obj));
        }
        return Optional.empty();
    }

    public BasePrice createBasePrice(BasePrice basePrice) {
        log.info("Creating BasePrice for year: {}, paymentItemId: {}, gradeId: {}",
                basePrice.getPriceYear(), basePrice.getPaymentItemId(), basePrice.getGradeId());
        return basePriceRepository.save(basePrice);
    }

    public BasePrice updateBasePrice(Long id, BasePrice basePrice) {
        return basePriceRepository.findById(id)
                .map(existingBasePrice -> {
                    updateExistingPrice(existingBasePrice, basePrice);
                    log.info("Updating BasePrice with id {}, new year: {}, paymentItemId: {}, gradeId: {}",
                            id, basePrice.getPriceYear(), basePrice.getPaymentItemId(), basePrice.getGradeId());
                    return basePriceRepository.save(existingBasePrice);
                })
                .orElseThrow(() -> {
                    log.error("BasePrice not found for id {}", id);
                    return new RuntimeException("BasePrice not found for id " + id);
                });
    }

    private void updateExistingPrice(BasePrice existing, BasePrice updated) {
        existing.setPriceYear(updated.getPriceYear());
        existing.setPaymentItemId(updated.getPaymentItemId());
        existing.setPaymentItemPrice(updated.getPaymentItemPrice());
        existing.setGradeId(updated.getGradeId());
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

