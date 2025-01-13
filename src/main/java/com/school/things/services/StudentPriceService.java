package com.school.things.services;

import com.school.things.entities.student.StudentPrice;
import com.school.things.repositories.StudentPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPriceService {

    @Autowired
    private StudentPriceRepository studentPriceRepository;

    public List<StudentPrice> getAllStudentPrices() {
        return studentPriceRepository.findAll();
    }
    public Optional<StudentPrice> getStudentPriceById(Long priceId) {
        return studentPriceRepository.findById(priceId);
    }
    public StudentPrice createStudentPrice(StudentPrice studentPrice) {
        return studentPriceRepository.save(studentPrice);
    }
    public StudentPrice updateStudentPrice(Long priceId, StudentPrice updatedStudentPrice) {
        return studentPriceRepository.findById(priceId).map(existingPrice -> {
            existingPrice.setOwnerId(updatedStudentPrice.getOwnerId());
            existingPrice.setPriceId(updatedStudentPrice.getPriceId());
            existingPrice.setActive(updatedStudentPrice.getActive());
            return studentPriceRepository.save(existingPrice);
        }).orElseThrow(() -> new RuntimeException("Student Price isn't found by id " + priceId));
    }
    public boolean deleteStudentPrice(Long id) {
        if (studentPriceRepository.existsById(id)) {
            studentPriceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
