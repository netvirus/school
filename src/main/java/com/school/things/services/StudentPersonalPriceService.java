package com.school.things.services;

import com.school.things.entities.student.StudentPrice;
import com.school.things.repositories.StudentPersonalPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPersonalPriceService {

    @Autowired
    private StudentPersonalPriceRepository studentPersonalPriceRepository;

    public List<StudentPrice> getAllStudentPersonalPrices() {
        return studentPersonalPriceRepository.findAll();
    }
    public Optional<StudentPrice> getStudentPersonalPriceById(Long priceId) {
        return studentPersonalPriceRepository.findById(priceId);
    }
    public StudentPrice createStudentPersonalPrice(StudentPrice studentPrice) {
        return studentPersonalPriceRepository.save(studentPrice);
    }
    public StudentPrice updateStudentPersonalPrice(Long priceId, StudentPrice updatedStudentPrice) {
        return studentPersonalPriceRepository.findById(priceId).map(existingPrice -> {
            existingPrice.setPriceName(updatedStudentPrice.getPriceName());
            existingPrice.setOwnerId(updatedStudentPrice.getOwnerId());
            existingPrice.setActive(updatedStudentPrice.getActive());
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
