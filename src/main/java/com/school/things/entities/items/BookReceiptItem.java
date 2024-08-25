package com.school.things.entities.items;

import com.school.things.entities.BookReceipt;
import com.school.things.entities.Books;
import jakarta.persistence.*;

@Entity
public class BookReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = false)
    private BookReceipt bookReceipt;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookReceipt getBookReceipt() {
        return bookReceipt;
    }

    public void setBookReceipt(BookReceipt bookReceipt) {
        this.bookReceipt = bookReceipt;
    }
}
