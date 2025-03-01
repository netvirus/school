package com.school.things.dto.student;

import com.school.things.dto.grade.GradeDTO;
import com.school.things.dto.payment.PaymentCurrencyDTO;

import java.util.List;

public record StudentPriceDTO(
        Long id,
        GradeDTO gradeDto,
        List<StudentServiceDiscountListDTO> studentServiceDiscountListDto,
        PaymentCurrencyDTO paymentCurrencyDTO,
        List<StudentPaymentDTO> studentPaymentDTO
) {}
