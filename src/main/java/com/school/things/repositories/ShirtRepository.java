package com.school.things.repositories;

import com.school.things.entities.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, Long> {
}
