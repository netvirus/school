package com.school.things.controllers;

import com.school.things.entities.items.Books;
import com.school.things.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Books> getBookById(@PathVariable Long id) {
        return booksService.getById(id);
    }

    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return booksService.save(book);
    }

    @PutMapping("/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books book) {
        return booksService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        booksService.delete(id);
    }
}
