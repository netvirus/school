package com.school.things.dto.payment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentCurrencyDTO {
    private Long id;
    private String name;
}
