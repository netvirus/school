package com.school.things.services;

import com.school.things.dto.StudentMapper;
import com.school.things.dto.student.StudentPriceDTO;
import com.school.things.entities.price.Price;
import com.school.things.entities.school.LearningCycle;
import com.school.things.entities.school.LearningCycleMonth;
import com.school.things.entities.student.Grade;
import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPayment;
import com.school.things.entities.student.StudentPrice;
import com.school.things.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentPriceService {

    @Autowired
    private StudentPriceRepository studentPriceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private LearningCycleRepository learningCycleRepository;

    @Autowired
    StudentMapper studentMapper;

    public List<StudentPrice> getAllStudentPrices() {
        return studentPriceRepository.findAll();
    }

    public StudentPriceDTO getStudentPriceById(Long priceId) {
        StudentPrice studentPrice = studentPriceRepository.findById(priceId).orElse(null);
        if (studentPrice != null) {
            return studentMapper.convertStudentPriceToDTO(studentPrice);
        }
        return null;
    }

    @Transactional
    public StudentPrice createStudentPrice(Long studentId, Long gradeId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Студент не найден"));

        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Грейд не найден"));

        Price price = priceRepository.findById(grade.getPrice().getId())
                .orElseThrow(() -> new RuntimeException("Прайс для этого грейда не найден"));

        StudentPrice studentPrice = new StudentPrice();
        studentPrice.setStudent(student);
        studentPrice.getGrade().setPrice(price);

        LearningCycle learningCycle = learningCycleRepository.findLatestCycle()
                .orElseThrow(() -> new RuntimeException("Учебный цикл не найден"));

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
            existingPrice.setGrade(updatedStudentPrice.getGrade());
            return studentPriceRepository.save(existingPrice);
        }).orElseThrow(() -> new RuntimeException("Student Price isn't found by id " + priceId));
    }
    public void deleteStudentPrice(Long id) {
        if (studentPriceRepository.existsById(id)) {
            studentPriceRepository.deleteById(id);
        }
    }
}
