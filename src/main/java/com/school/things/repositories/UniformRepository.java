package com.school.things.repositories;

import com.school.things.entities.Uniform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniformRepository extends JpaRepository<Uniform, Long> {
}
