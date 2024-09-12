package com.school.things.services;

import com.school.things.entities.pricelist.PersonalDiscount;
import com.school.things.repositories.PersonalDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDiscountService {

    @Autowired
    private PersonalDiscountRepository personalDiscountRepository;

    public List<PersonalDiscount> getAllPersonalDiscounts() {
        return personalDiscountRepository.findAll();
    }

    public Optional<PersonalDiscount> getDiscountById(Long id) {
        return personalDiscountRepository.findById(id);
    }

    public Optional<PersonalDiscount> getDiscountByStudentId(Long studentId) {
        return personalDiscountRepository.findByStudentId(studentId);
    }

    public PersonalDiscount savePersonalDiscount(PersonalDiscount personalDiscount) {
        return personalDiscountRepository.save(personalDiscount);
    }

    public void deletePersonalDiscount(Long id) {
        personalDiscountRepository.deleteById(id);
    }
}
