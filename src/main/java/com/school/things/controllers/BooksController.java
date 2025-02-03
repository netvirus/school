package com.school.things.controllers;

import com.school.things.entities.items.Book;
import com.school.things.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return booksService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return booksService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return booksService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
    }
}
