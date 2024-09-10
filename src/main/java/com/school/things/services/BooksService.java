package com.school.things.services;

import com.school.things.entities.Book;
import com.school.things.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return booksRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        return booksRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setGrade(book.getGrade());
                    existingBook.setColor(book.getColor());
                    return booksRepository.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}
