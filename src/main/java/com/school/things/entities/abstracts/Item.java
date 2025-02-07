package com.school.things.entities.abstracts;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "color", length = 30, nullable = false)
    private String color;
}
