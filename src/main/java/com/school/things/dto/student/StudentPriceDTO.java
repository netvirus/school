package com.school.things.dto.student;

import com.school.things.dto.grade.GradeDTO;
import com.school.things.dto.payment.PaymentDTO;
import com.school.things.dto.payment.PaymentPeriodDTO;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class StudentPriceDTO {
    private Long id;
    private Boolean active;
    private GradeDTO gradeDto;
    private List<StudentServiceDiscountListDTO> studentServiceDiscountListDto;
    private PaymentPeriodDTO paymentPeriodDto;
    private PaymentDTO paymentDto;
}
