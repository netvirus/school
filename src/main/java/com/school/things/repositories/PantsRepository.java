package com.school.things.repositories;

import com.school.things.entities.items.Pants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantsRepository extends JpaRepository<Pants, Long> {
}
