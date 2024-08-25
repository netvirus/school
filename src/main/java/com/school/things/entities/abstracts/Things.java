package com.school.things.entities.abstracts;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Things {

    private String name;
    private String color;

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
