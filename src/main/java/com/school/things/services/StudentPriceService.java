package com.school.things.services;

import com.school.things.dto.StudentMapper;
import com.school.things.dto.student.StudentPriceDTO;
import com.school.things.entities.price.Price;
import com.school.things.entities.school.LearningCycle;
import com.school.things.entities.school.LearningCycleMonth;
import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPayment;
import com.school.things.entities.student.StudentPrice;
import com.school.things.repositories.LearningCycleRepository;
import com.school.things.repositories.StudentPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentPriceService {

    @Autowired
    private StudentPriceRepository studentPriceRepository;

    @Autowired
    private LearningCycleRepository learningCycleRepository;

    public List<StudentPrice> getAllStudentPrices() {
        return studentPriceRepository.findAll();
    }

    public StudentPriceDTO getStudentPriceById(Long priceId) {
        StudentPrice studentPrice = studentPriceRepository.findById(priceId).orElse(null);
        if (studentPrice != null) {
            return StudentMapper.convertStudentPriceToDTO(studentPrice);
        }
        return null;
    }

    public StudentPrice createStudentPrice(Student student, Price price, int paymentPeriod) {
        StudentPrice studentPrice = new StudentPrice();
        studentPrice.setStudent(student);
        studentPrice.setPaymentPeriod(paymentPeriod);
        studentPrice.setActive(true);

        LearningCycle learningCycle = learningCycleRepository.findLatestCycle();
        List<StudentPayment> payments = new ArrayList<>();

        for (LearningCycleMonth month : learningCycle.getMonths()) {
            StudentPayment payment = new StudentPayment();
            payment.setStudentPrice(studentPrice);
            payment.setMonth(month.getMonth());
            payment.setYear(month.getYear());
            payment.setPaid(false);
            payment.setAmountPaid(0);
            payments.add(payment);
        }

        studentPrice.setPayments(payments);
        return studentPriceRepository.save(studentPrice);
    }

    public StudentPrice updateStudentPrice(Long priceId, StudentPrice updatedStudentPrice) {
        return studentPriceRepository.findById(priceId).map(existingPrice -> {
            existingPrice.setStudent(updatedStudentPrice.getStudent());
            existingPrice.setActive(updatedStudentPrice.getActive());
            existingPrice.setGrade(updatedStudentPrice.getGrade());
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
