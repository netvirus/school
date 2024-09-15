package com.school.things.services;

import com.school.things.entities.pricelist.AcademicYearPersonalPrice;
import com.school.things.repositories.AcademicYearPersonalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicYearPersonalPriceService {

    @Autowired
    private AcademicYearPersonalPriceRepository academicYearPersonalPriceRepository;

    public List<AcademicYearPersonalPrice> getAllAcademicYearPersonalPrices() {
        return academicYearPersonalPriceRepository.findAll();
    }

    public Optional<AcademicYearPersonalPrice> getAcademicYearPersonalPriceById(Long id) {
        return academicYearPersonalPriceRepository.findById(id);
    }

    public List<AcademicYearPersonalPrice> getAcademicYearPersonalPricesByStudentId(Long studentId) {
        return academicYearPersonalPriceRepository.findByStudentId(studentId);
    }

    public List<AcademicYearPersonalPrice> getAcademicYearPersonalPricesByYearAndGrade(int year, int gradeId) {
        return academicYearPersonalPriceRepository.findByAcademicYearAndGradeId(year, gradeId);
    }

    public AcademicYearPersonalPrice createAcademicYearPersonalPrice(AcademicYearPersonalPrice academicYearPersonalPrice) {
        return academicYearPersonalPriceRepository.save(academicYearPersonalPrice);
    }

    public AcademicYearPersonalPrice updateAcademicYearPersonalPrice(Long id, AcademicYearPersonalPrice academicYearPersonalPrice) {
        return academicYearPersonalPriceRepository.findById(id)
                .map(existingPrice -> {
                    existingPrice.setAcademicYear(academicYearPersonalPrice.getAcademicYear());
                    existingPrice.setGradeId(academicYearPersonalPrice.getGradeId());
                    existingPrice.setStudentId(academicYearPersonalPrice.getStudentId());
                    existingPrice.setPaymentMonths(academicYearPersonalPrice.getPaymentMonths());
                    existingPrice.setDiscountInMonths(academicYearPersonalPrice.getDiscountInMonths());
                    existingPrice.setAcademicBasePriceId(academicYearPersonalPrice.getAcademicBasePriceId());
                    return academicYearPersonalPriceRepository.save(existingPrice);
                })
                .orElseThrow(() -> new RuntimeException("Academic Year Personal Price not found"));
    }

    public void deleteAcademicYearPersonalPrice(Long id) {
        academicYearPersonalPriceRepository.deleteById(id);
    }
}
