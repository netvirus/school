package com.school.things.repositories;

import com.school.things.entities.Storekeeper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorekeeperRepository extends JpaRepository<Storekeeper, Long> {
}
