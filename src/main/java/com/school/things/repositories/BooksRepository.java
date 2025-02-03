package com.school.things.repositories;

import com.school.things.entities.items.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

}
