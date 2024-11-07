package com.school.things.services;

import com.school.things.entities.prices.StudentPersonalPrice;
import com.school.things.repositories.StudentPersonalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPersonalPriceService {

    @Autowired
    private StudentPersonalPriceRepository studentPersonalPriceRepository;

    public List<StudentPersonalPrice> getAllStudentPersonalPrices() {
        return studentPersonalPriceRepository.findAll();
    }
    public Optional<StudentPersonalPrice> getStudentPersonalPriceById(Long priceId) {
        return studentPersonalPriceRepository.findById(priceId);
    }
    public StudentPersonalPrice createStudentPersonalPrice(StudentPersonalPrice studentPersonalPrice) {
        return studentPersonalPriceRepository.save(studentPersonalPrice);
    }
    public StudentPersonalPrice updateStudentPersonalPrice(Long priceId, StudentPersonalPrice updatedStudentPersonalPrice) {
        return studentPersonalPriceRepository.findById(priceId).map(existingPrice -> {
            existingPrice.setPriceName(updatedStudentPersonalPrice.getPriceName());
            existingPrice.setOwnerId(updatedStudentPersonalPrice.getOwnerId());
            existingPrice.setActive(updatedStudentPersonalPrice.getActive());
            return studentPersonalPriceRepository.save(existingPrice);
        }).orElseThrow(() -> new RuntimeException("Student Personal Price isn't found by id " + priceId));
    }
    public boolean deleteStudentPersonalPrice(Long id) {
        if (studentPersonalPriceRepository.existsById(id)) {
            studentPersonalPriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
