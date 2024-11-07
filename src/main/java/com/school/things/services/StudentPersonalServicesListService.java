package com.school.things.services;

import com.school.things.entities.prices.StudentPersonalServicesList;
import com.school.things.repositories.StudentPersonalServicesListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPersonalServicesListService {

    @Autowired
    private StudentPersonalServicesListRepository studentPersonalServicesListRepository;

    public List<StudentPersonalServicesList> getAllStudentPersonalServicesList() {
        return studentPersonalServicesListRepository.findAll();
    }

    public Optional<StudentPersonalServicesList> getStudentPersonalServicesListById(Long id) {
        return studentPersonalServicesListRepository.findById(id);
    }

    public StudentPersonalServicesList createStudentPersonalServicesList(StudentPersonalServicesList studentPersonalPrice) {
        return studentPersonalServicesListRepository.save(studentPersonalPrice);
    }

    public StudentPersonalServicesList updateStudentPersonalServicesList(Long id, StudentPersonalServicesList updatedStudentPersonalServicesList) {
        return studentPersonalServicesListRepository.findById(id).map(existingPrices -> {
            existingPrices.setPersonalPriceId(updatedStudentPersonalServicesList.getPersonalPriceId());
            existingPrices.setSchoolServiceId(updatedStudentPersonalServicesList.getSchoolServiceId());
            existingPrices.setSchoolServiceCost(updatedStudentPersonalServicesList.getSchoolServiceCost());
            return studentPersonalServicesListRepository.save(existingPrices);
        }).orElseThrow(() -> new RuntimeException("Student Personal Services List isn't found by id " + id));
    }

    public boolean deleteStudentPersonalServicesList(Long id) {
        if (studentPersonalServicesListRepository.existsById(id)) {
            studentPersonalServicesListRepository.deleteById(id);
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
