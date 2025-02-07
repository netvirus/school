package com.school.things.entities.items;

import com.school.things.entities.abstracts.Item;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Uniform extends Item {
    @Column(name = "size", length = 10, nullable = false)
    private int size;
}
