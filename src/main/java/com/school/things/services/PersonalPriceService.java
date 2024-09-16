package com.school.things.services;

import com.school.things.entities.pricelist.PersonalPrice;
import com.school.things.repositories.PersonalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalPriceService {

    @Autowired
    private PersonalPriceRepository academicYearPersonalPriceRepository;

    public List<PersonalPrice> getAllAcademicYearPersonalPrices() {
        return academicYearPersonalPriceRepository.findAll();
    }

    public Optional<PersonalPrice> getAcademicYearPersonalPriceById(Long id) {
        return academicYearPersonalPriceRepository.findById(id);
    }

    public List<PersonalPrice> getAcademicYearPersonalPricesByStudentId(Long studentId) {
        return academicYearPersonalPriceRepository.findByStudentId(studentId);
    }

    public List<PersonalPrice> getAcademicYearPersonalPricesByYearAndGrade(int year, int gradeId) {
        return academicYearPersonalPriceRepository.findByAcademicYearAndGradeId(year, gradeId);
    }

    public PersonalPrice createAcademicYearPersonalPrice(PersonalPrice academicYearPersonalPrice) {
        return academicYearPersonalPriceRepository.save(academicYearPersonalPrice);
    }

    public PersonalPrice updateAcademicYearPersonalPrice(Long id, PersonalPrice academicYearPersonalPrice) {
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
