package com.school.things.services;

import com.school.things.entities.pricelist.AcademicYearBasePrice;
import com.school.things.repositories.AcademicYearBasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AcademicYearBasePriceService {

    @Autowired
    private AcademicYearBasePriceRepository academicYearBasePriceRepository;

    public List<AcademicYearBasePrice> getAllPrices() {
        List<Object[]> results = academicYearBasePriceRepository.findAllWithPaymentItemName();
        List<AcademicYearBasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            AcademicYearBasePrice price = new AcademicYearBasePrice();
            price.setId((Long) result[0]);
            price.setPaymentItemId((Long) result[1]);
            price.setPaymentItemPrice((Double) result[2]);
            price.setPriceYear((Integer) result[3]);
            price.setPaymentItemName((String) result[4]);

            prices.add(price);
        }

        return prices;
    }

    public AcademicYearBasePrice getPriceById(Long id) {
        Object[] result = academicYearBasePriceRepository.findByIdWithPaymentItemName(id);

        AcademicYearBasePrice price = new AcademicYearBasePrice();
        price.setId((Long) result[0]);
        price.setPaymentItemId((Long) result[1]);
        price.setPaymentItemPrice((Double) result[2]);
        price.setPriceYear((Integer) result[3]);
        price.setPaymentItemName((String) result[4]);

        return price;
    }

    public AcademicYearBasePrice createAcademicYearBasePrice(AcademicYearBasePrice academicYearBasePrice) {
        return academicYearBasePriceRepository.save(academicYearBasePrice);
    }

    public AcademicYearBasePrice updateAcademicYearBasePrice(Long id, AcademicYearBasePrice academicYearBasePrice) {
        return academicYearBasePriceRepository.findById(id)
                .map(existingBasePrice -> {
                    existingBasePrice.setPriceYear(academicYearBasePrice.getPriceYear());
                    existingBasePrice.setPaymentItemId(academicYearBasePrice.getPaymentItemId());
                    existingBasePrice.setPaymentItemPrice(academicYearBasePrice.getPaymentItemPrice());
                    return academicYearBasePriceRepository.save(existingBasePrice);
                })
                .orElseThrow(() -> new RuntimeException("Academic Year Base Price not found"));
    }

    public boolean deleteAcademicYearBasePrice(Long id) {
        Optional<AcademicYearBasePrice> existingPrice = academicYearBasePriceRepository.findById(id);
        if (existingPrice.isPresent()) {
            academicYearBasePriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
