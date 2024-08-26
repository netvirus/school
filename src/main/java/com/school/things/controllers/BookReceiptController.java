package com.school.things.controllers;

import com.school.things.entities.BookReceipt;
import com.school.things.entities.items.BookReceiptItem;
import com.school.things.requests.BookItemRequest;
import com.school.things.requests.BookReceiptRequest;
import com.school.things.entities.items.Books;
import com.school.things.repositories.BookReceiptRepository;
import com.school.things.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/book-receipts")
public class BookReceiptController {

    @Autowired
    private BookReceiptRepository bookReceiptRepository;

    @Autowired
    private BooksRepository booksRepository;

    @PostMapping
    public ResponseEntity<BookReceipt> createReceipt(@RequestBody BookReceiptRequest request) {
        BookReceipt receipt = new BookReceipt();
        List<BookReceiptItem> items = new ArrayList<>();

        for (BookItemRequest itemRequest : request.getItems()) {
            Books book;
            if (itemRequest.getBookId() != null) {
                book = booksRepository.findById(itemRequest.getBookId())
                        .orElseThrow(() -> new RuntimeException("Book not found"));
                book.setName(itemRequest.getName());
                book.setColor(itemRequest.getColor());
                book.setUnit(itemRequest.getUnit());
                book.setGrade(itemRequest.getGrade());
            } else {
                book = new Books();
                book.setName(itemRequest.getName());
                book.setColor(itemRequest.getColor());
                book.setUnit(itemRequest.getUnit());
                book.setGrade(itemRequest.getGrade());
            }

            booksRepository.save(book);

            BookReceiptItem item = new BookReceiptItem();
            item.setBook(book);
            item.setQuantity(itemRequest.getQuantity());
            item.setBookReceipt(receipt);
            items.add(item);
        }

        receipt.setItems(items);
        BookReceipt savedReceipt = bookReceiptRepository.save(receipt);
        return ResponseEntity.ok(savedReceipt);
    }
}
