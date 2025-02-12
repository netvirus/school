package com.school.things.dto.price;

import com.school.things.dto.payment.PaymentPeriodDTO;
import com.school.things.dto.student.StudentServiceListDTO;
import lombok.*;

import java.util.List;

@Data
@Builder
public class PriceDTO {
    private Long id;
    private String name;
//    private List<PriceServiceListDTO> priceServiceList;
    private List<StudentServiceListDTO> studentServiceLists;
    private PaymentPeriodDTO paymentPeriod;
}
