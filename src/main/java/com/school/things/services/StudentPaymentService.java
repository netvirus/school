package com.school.things.services;

import com.school.things.dto.StudentPaymentMapper;
import com.school.things.dto.payment.PaymentDTO;
import com.school.things.dto.student.StudentPaymentDTO;
import com.school.things.entities.payment.Payment;
import com.school.things.entities.school.LearningCycle;
import com.school.things.entities.school.LearningCycleMonth;
import com.school.things.entities.student.StudentPayment;
import com.school.things.entities.student.StudentPrice;
import com.school.things.entities.student.StudentServiceDiscountList;
import com.school.things.repositories.LearningCycleRepository;
import com.school.things.repositories.PaymentRepository;
import com.school.things.repositories.StudentPaymentRepository;
import com.school.things.repositories.StudentPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentPaymentService {
    private final StudentPaymentRepository studentPaymentRepository;
    private final LearningCycleRepository learningCycleRepository;
    private final StudentPaymentMapper studentPaymentMapper;
    private final StudentPriceRepository studentPriceRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public StudentPaymentService(StudentPaymentRepository studentPaymentRepository,
                                 LearningCycleRepository learningCycleRepository,
                                 StudentPaymentMapper studentPaymentMapper, StudentPriceRepository studentPriceRepository, PaymentRepository paymentRepository) {
        this.studentPaymentRepository = studentPaymentRepository;
        this.learningCycleRepository = learningCycleRepository;
        this.studentPaymentMapper = studentPaymentMapper;
        this.studentPriceRepository = studentPriceRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<StudentPaymentDTO> getPaymentStatusByStudentPriceId(Long studentPriceId) {
        LearningCycle learningCycle = learningCycleRepository.findLatestCycle()
                .orElseThrow(() -> new RuntimeException("Learning Cycle isn't found"));

        List<LearningCycleMonth> months = learningCycle.getMonths();
        List<StudentPayment> studentPayments = studentPaymentRepository.findByStudentPriceId(studentPriceId);
        List<Payment> allPayments = paymentRepository.findByStudentPriceId(studentPriceId);

        StudentPrice studentPrice = studentPriceRepository.findById(studentPriceId)
                .orElseThrow(() -> new RuntimeException("Student Price not found"));

        double totalAmount = studentPrice.getStudentServiceDiscountList().stream()
                .mapToDouble(StudentServiceDiscountList::getCostWithDiscount)
                .sum();

        double monthlyAmount = BigDecimal.valueOf(totalAmount / months.size())
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        return months.stream()
                .map(month -> {
                    Optional<StudentPayment> studentPaymentOpt = studentPayments.stream()
                            .filter(p -> p.getMonth() == month.getMonth() && p.getYear() == month.getYear())
                            .findFirst();

                    boolean isPaid = studentPaymentOpt.map(StudentPayment::isPaid).orElse(false);

                    List<PaymentDTO> paymentDTOs = allPayments.stream()
                            .filter(payment -> payment.getMonth() == month.getMonth() && payment.getYear() == month.getYear())
                            .map(payment -> new PaymentDTO(payment.getId(), payment.getMonth(), payment.getYear(), payment.getAmount()))
                            .collect(Collectors.toList());

                    double totalPaidForMonth = paymentDTOs.stream()
                            .mapToDouble(PaymentDTO::amount)
                            .sum();

                    double remainingAmount = BigDecimal.valueOf(monthlyAmount - totalPaidForMonth)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();

                    return new StudentPaymentDTO(
                            month.getId(),
                            month.getMonth(),
                            month.getYear(),
                            isPaid,
                            remainingAmount,
                            paymentDTOs
                    );
                })
                .collect(Collectors.toList());
    }
}
