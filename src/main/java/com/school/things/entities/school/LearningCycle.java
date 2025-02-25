package com.school.things.entities.school;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "learning_cycles")
public class LearningCycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name; // Например: "2024-2025"

    @OneToMany(mappedBy = "learningCycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LearningCycleMonth> months = new ArrayList<>();
}
