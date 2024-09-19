package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class BasePriceService {

    private static final Logger log = LoggerFactory.getLogger(BasePriceService.class);

    @Autowired
    private BasePriceRepository basePriceRepository;

    // Метод для проверки на наличие null в любом элементе массива
    private boolean isAnyElementNull(Object[] array) {
        return Objects.isNull(array) || Objects.nonNull(array) && Arrays.stream(array).anyMatch(Objects::isNull);
    }

    public List<BasePrice> getAllPrices() {
        List<Object[]> results = basePriceRepository.findAllWithPaymentItemNameAndGrade();
        List<BasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            if (isAnyElementNull(result)) {
                log.warn("Skipping record due to null values");
                continue; // Пропуск записи, если есть null элементы
            }

            BasePrice price = new BasePrice();
            price.setId(((Number) result[0]).longValue());
            price.setPaymentItemId(((Number) result[1]).longValue());
            price.setPaymentItemPrice((Double) result[2]);
            price.setPriceYear((Integer) result[3]);
            price.setPaymentItemName((String) result[4]);
            price.setGradeName((String) result[5]);

            prices.add(price);
        }
        log.info("Fetched {} BasePrice records", prices.size());
        return prices;
    }

    public BasePrice getPriceById(Long id) {
        Object[] result = basePriceRepository.findByIdWithPaymentItemNameAndGrade(id);

        if (isAnyElementNull(result)) {
            log.warn("BasePrice not found or contains null values for id {}", id);
            throw new RuntimeException("BasePrice not found or invalid data for id " + id);
        }

        BasePrice price = new BasePrice();
        price.setId(((Number) result[0]).longValue());
        price.setPaymentItemId(((Number) result[1]).longValue());
        price.setPaymentItemPrice((Double) result[2]);
        price.setPriceYear((Integer) result[3]);
        price.setPaymentItemName((String) result[4]);
        price.setGradeName((String) result[5]);

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
