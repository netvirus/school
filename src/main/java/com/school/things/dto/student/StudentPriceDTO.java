package com.school.things.dto.student;

import com.school.things.dto.grade.GradeDTO;
import com.school.things.dto.payment.PaymentCurrencyDTO;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class StudentPriceDTO {
    private Long id;
    private int paymentPeriod;
    private Boolean active;
    private GradeDTO gradeDto;
    private List<StudentServiceDiscountListDTO> studentServiceDiscountListDto;
    private PaymentCurrencyDTO paymentCurrencyDTO;
}
