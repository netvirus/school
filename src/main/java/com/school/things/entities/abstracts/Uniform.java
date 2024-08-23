package com.school.things.entities.abstracts;

import com.school.things.entities.abstracts.Things;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Uniform extends Things {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
