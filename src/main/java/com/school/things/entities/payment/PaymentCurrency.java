package com.school.things.entities.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.things.entities.student.StudentPrice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY)
    private List<StudentPrice> studentPrice;

    public PaymentCurrency(Long id, String name) {
    }
}
