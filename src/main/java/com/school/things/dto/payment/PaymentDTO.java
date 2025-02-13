package com.school.things.dto.payment;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PaymentDTO {
    private Long id;
    private double amount;
}
