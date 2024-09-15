package com.school.things.services;

import com.school.things.entities.pricelist.AcademicYearBasePrice;
import com.school.things.repositories.AcademicYearBasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicYearBasePriceService {

    @Autowired
    private AcademicYearBasePriceRepository academicYearBasePriceRepository;

    public List<AcademicYearBasePrice> getAllAcademicYearBasePrices() {
        return academicYearBasePriceRepository.findAll();
    }

    public Optional<AcademicYearBasePrice> getAcademicYearBasePriceById(Long id) {
        return academicYearBasePriceRepository.findById(id);
    }

    public List<AcademicYearBasePrice> getAcademicYearBasePricesByYear(int year) {
        return academicYearBasePriceRepository.findByPriceYear(year);
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

    public void deleteAcademicYearBasePrice(Long id) {
        academicYearBasePriceRepository.deleteById(id);
    }
}
