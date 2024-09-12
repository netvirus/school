package com.school.things.services;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.repositories.BasePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasePriceService {

    @Autowired
    private BasePriceRepository basePriceRepository;

    public List<BasePrice> getAllBasePrices() {
        return basePriceRepository.findAll();
    }

    public Optional<BasePrice> getBasePriceById(Long id) {
        return basePriceRepository.findById(id);
    }

    public BasePrice saveBasePrice(BasePrice basePrice) {
        return basePriceRepository.save(basePrice);
    }

    public BasePrice updateBasePrice(Long id, BasePrice updatedBasePrice) {
        return basePriceRepository.findById(id)
                .map(existingPrice -> {
                    existingPrice.setGradeLevelId(updatedBasePrice.getGradeLevelId());
                    existingPrice.setAnnualModulesFee(updatedBasePrice.getAnnualModulesFee());
                    existingPrice.setLegacyTlp(updatedBasePrice.getLegacyTlp());
                    existingPrice.setUniform(updatedBasePrice.getUniform());
                    existingPrice.setFood(updatedBasePrice.getFood());
                    existingPrice.setAnnualMiscellaneousFee(updatedBasePrice.getAnnualMiscellaneousFee());
                    existingPrice.setFieldTripCampRecognition(updatedBasePrice.getFieldTripCampRecognition());
                    existingPrice.setLsaFeeOneTime(updatedBasePrice.getLsaFeeOneTime());
                    existingPrice.setRegistrationFeeOneTime(updatedBasePrice.getRegistrationFeeOneTime());
                    return basePriceRepository.save(existingPrice);
                })
                .orElseThrow(() -> new RuntimeException("Base price not found"));
    }

    public void deleteBasePrice(Long id) {
        basePriceRepository.deleteById(id);
    }
}
