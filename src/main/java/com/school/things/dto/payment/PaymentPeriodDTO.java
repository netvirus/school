package com.school.things.dto.payment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentPeriodDTO {
    private Long id;
    private int period;
    private PaymentCurrencyDTO paymentCurrencyDTO;
}
