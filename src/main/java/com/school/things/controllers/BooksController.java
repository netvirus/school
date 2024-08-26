package com.school.things.controllers;

import com.school.things.entities.items.Books;
import com.school.things.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private ThingService thingService;

    @GetMapping
    public List<Books> getAllBooks() {
        return thingService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Books> getBookById(@PathVariable Long id) {
        return thingService.getBookById(id);
    }

    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return thingService.saveBook(book);
    }

    @PutMapping("/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books book) {
        return thingService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        thingService.deleteBook(id);
    }
}
