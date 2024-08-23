package com.school.things.repositories;

import com.school.things.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findBySubject(String subject);
}
