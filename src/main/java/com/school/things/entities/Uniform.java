package com.school.things.entities;

import com.school.things.entities.abstracts.Item;
import jakarta.persistence.*;

@Entity
public class Uniform extends Item {
    @Column(name = "size", length = 10, nullable = false)
    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
