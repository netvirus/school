package com.school.things.services;

import com.school.things.entities.student.StudentDiscount;
import com.school.things.repositories.StudentDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDiscountService {

    @Autowired
    private StudentDiscountRepository studentDiscountRepository;

    public List<StudentDiscount> getAllStudentDiscounts() {
        return studentDiscountRepository.findAll();
    }

    public Optional<StudentDiscount> getStudentDiscountById(Long id) {
        return studentDiscountRepository.findById(id);
    }

    public StudentDiscount createStudentDiscount(StudentDiscount studentDiscount) {
        return studentDiscountRepository.save(studentDiscount);
    }

    public StudentDiscount updateStudentDiscount(Long id, StudentDiscount updatedStudentDiscount) {
        return studentDiscountRepository.findById(id).map(existingPrices -> {
            existingPrices.setStudent(updatedStudentDiscount.getStudent());
            existingPrices.setStudentPrice(updatedStudentDiscount.getStudentPrice());
            existingPrices.setDiscount(updatedStudentDiscount.getDiscount());
            return studentDiscountRepository.save(existingPrices);
        }).orElseThrow(() -> new RuntimeException("Student Discount isn't found by id " + id));
    }

    public boolean deleteStudentDiscount(Long id) {
        if (studentDiscountRepository.existsById(id)) {
            studentDiscountRepository.deleteById(id);
            return true;
        }
        return false;
    }
//
//    @Transactional
//    public StudentPersonalServicesList createAndClonePrices(Long previousPriceId, int newPriceYear) {
//        Optional<StudentPersonalPrice> previousPricesOpt = studentPersonalPriceRepository.findById(previousPriceId);
//        if (previousPricesOpt.isEmpty()) {
//            throw new RuntimeException("Previous Price not found for id " + previousPriceId);
//        }
//
//        StudentPersonalPrice previousStudentPersonalPrice = previousPricesOpt.get();
//        StudentPersonalPrice newStudentPersonalPrice = new StudentPersonalServicesList(newPriceYear, previousStudentPersonalPrice.getDescription());
//        newStudentPersonalPrice = studentPersonalPriceRepository.save(newStudentPersonalPrice);
//
//        List<BasePrice> previousBasePrices = basePriceRepository.findByPrices(previousStudentPersonalPrice);
//
////        for (BasePrice previousBasePrice : previousBasePrices) {
////            BasePrice newBasePrice = new BasePrice(
////                    newPrices,
////                    previousBasePrice.getPaymentItem(),
////                    previousBasePrice.getGrade(),
////                    previousBasePrice.getPaymentItemPrice()
////            );
////            basePriceRepository.save(newBasePrice);
////        }
//        return newStudentPersonalPrice;
//    }
}
