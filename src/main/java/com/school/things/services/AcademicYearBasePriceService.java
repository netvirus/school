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

    // Получение всех цен с именем платежного элемента и gradeId
    public List<AcademicYearBasePrice> getAllPrices() {
        List<Object[]> results = academicYearBasePriceRepository.findAllWithPaymentItemNameAndGrade();
        List<AcademicYearBasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            AcademicYearBasePrice price = new AcademicYearBasePrice();
            price.setId((Long) result[0]);
            price.setPaymentItemId((Long) result[1]);
            price.setPaymentItemPrice((Double) result[2]);
            price.setPriceYear((Integer) result[3]);
            price.setPaymentItemName((String) result[4]);
            price.setGradeId((Long) result[5]);

            prices.add(price);
        }

        return prices;
    }

    // Получение цены по ID с именем платежного элемента и gradeId
    public AcademicYearBasePrice getPriceById(Long id) {
        Object[] result = academicYearBasePriceRepository.findByIdWithPaymentItemNameAndGrade(id);

        AcademicYearBasePrice price = new AcademicYearBasePrice();
        price.setId((Long) result[0]);
        price.setPaymentItemId((Long) result[1]);
        price.setPaymentItemPrice((Double) result[2]);
        price.setPriceYear((Integer) result[3]);
        price.setPaymentItemName((String) result[4]);
        price.setGradeId((Long) result[5]);

        return price;
    }

    // Создание записи
    public AcademicYearBasePrice createAcademicYearBasePrice(AcademicYearBasePrice academicYearBasePrice) {
        return academicYearBasePriceRepository.save(academicYearBasePrice);
    }

    // Обновление записи
    public AcademicYearBasePrice updateAcademicYearBasePrice(Long id, AcademicYearBasePrice academicYearBasePrice) {
        return academicYearBasePriceRepository.findById(id)
                .map(existingBasePrice -> {
                    existingBasePrice.setPriceYear(academicYearBasePrice.getPriceYear());
                    existingBasePrice.setPaymentItemId(academicYearBasePrice.getPaymentItemId());
                    existingBasePrice.setPaymentItemPrice(academicYearBasePrice.getPaymentItemPrice());
                    existingBasePrice.setGradeId(academicYearBasePrice.getGradeId());
                    return academicYearBasePriceRepository.save(existingBasePrice);
                })
                .orElseThrow(() -> new RuntimeException("Academic Year Base Price not found"));
    }

    // Удаление записи
    public boolean deleteAcademicYearBasePrice(Long id) {
        Optional<AcademicYearBasePrice> existingPrice = academicYearBasePriceRepository.findById(id);
        if (existingPrice.isPresent()) {
            academicYearBasePriceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Поиск по gradeId
    public List<AcademicYearBasePrice> getPricesByGradeId(Long gradeId) {
        List<Object[]> results = academicYearBasePriceRepository.findByGradeIdWithPaymentItemName(gradeId);
        List<AcademicYearBasePrice> prices = new ArrayList<>();

        for (Object[] result : results) {
            AcademicYearBasePrice price = new AcademicYearBasePrice();
            price.setId((Long) result[0]);
            price.setPaymentItemId((Long) result[1]);
            price.setPaymentItemPrice((Double) result[2]);
            price.setPriceYear((Integer) result[3]);
            price.setPaymentItemName((String) result[4]);
            price.setGradeId((Long) result[5]);

            prices.add(price);
        }

        return prices;
    }
}
