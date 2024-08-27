package com.school.things.repositories;

import com.school.things.entities.items.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShirtRepository extends JpaRepository<Shirt, Long> {
    List<Shirt> findByColor(String color);
}
