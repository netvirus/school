package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasePriceService {

    @Autowired
    private BasePriceRepository basePriceRepository;

    public List<BasePrice> getAllPrices() {
        List<Object[]> results = basePriceRepository.findAllWithPaymentItemNameAndGrade();
        List<BasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            BasePrice price = new BasePrice();
            price.setId((Long) result[0]);
            price.setPaymentItemId((Long) result[1]);
            price.setPaymentItemPrice((Double) result[2]);
            price.setPriceYear((Integer) result[3]);
            price.setPaymentItemName((String) result[4]);
            price.setGradeName((String) result[5]);

            prices.add(price);
        }

        return prices;
    }

    public BasePrice getPriceById(Long id) {
        Object[] result = basePriceRepository.findByIdWithPaymentItemNameAndGrade(id);

        BasePrice price = new BasePrice();
        price.setId((Long) result[0]);
        price.setPaymentItemId((Long) result[1]);
        price.setPaymentItemPrice((Double) result[2]);
        price.setPriceYear((Integer) result[3]);
        price.setPaymentItemName((String) result[4]);
        price.setGradeName((String) result[5]);

        return price;
    }

    public List<BasePrice> getPricesByGradeId(Long gradeId) {
        List<Object[]> results = basePriceRepository.findByGradeIdWithPaymentItemName(gradeId);
        List<BasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            BasePrice price = new BasePrice();
            price.setId((Long) result[0]);
            price.setPaymentItemId((Long) result[1]);
            price.setPaymentItemPrice((Double) result[2]);
            price.setPriceYear((Integer) result[3]);
            price.setPaymentItemName((String) result[4]);
            price.setGradeName((String) result[5]);

            prices.add(price);
        }

        return prices;
    }

    public BasePrice createAcademicYearBasePrice(BasePrice academicYearBasePrice) {
        return basePriceRepository.save(academicYearBasePrice);
    }

    public BasePrice updateAcademicYearBasePrice(Long id, BasePrice BasePrice) {
        return basePriceRepository.findById(id)
                .map(existingBasePrice -> {
                    existingBasePrice.setPriceYear(BasePrice.getPriceYear());
                    existingBasePrice.setPaymentItemId(BasePrice.getPaymentItemId());
                    existingBasePrice.setPaymentItemPrice(BasePrice.getPaymentItemPrice());
                    existingBasePrice.setGradeId(BasePrice.getGradeId());
                    return basePriceRepository.save(existingBasePrice);
                })
                .orElseThrow(() -> new RuntimeException("Academic Year Base Price not found"));
    }

    public boolean deleteAcademicYearBasePrice(Long id) {
        if (basePriceRepository.existsById(id)) {
            basePriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
