package com.school.things.services;

import com.school.things.entities.items.Books;
import com.school.things.repositories.BooksRepository;
import org.springframework.stereotype.Service;

@Service
public class BooksService extends GenericThingsService<Books, Long> {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        super(booksRepository);
        this.booksRepository = booksRepository;
    }

    @Override
    protected void copyProperties(Books existingBook, Books updatedBook) {
        existingBook.setName(updatedBook.getName());
        existingBook.setColor(updatedBook.getColor());
        existingBook.setUnit(updatedBook.getUnit());
        existingBook.setGrade(updatedBook.getGrade());
    }
}
