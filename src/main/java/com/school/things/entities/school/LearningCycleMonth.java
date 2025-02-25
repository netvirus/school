package com.school.things.entities.school;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "learning_cycle_months")
public class LearningCycleMonth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "learning_cycle_id", nullable = false)
    private LearningCycle learningCycle;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "year", nullable = false)
    private int year;
}
