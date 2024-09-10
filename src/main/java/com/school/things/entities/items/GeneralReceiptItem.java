package com.school.things.entities.items;

import com.school.things.entities.Book;
import com.school.things.entities.GeneralReceipt;
import jakarta.persistence.*;

@Entity
public class GeneralReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "general_receipt_id", nullable = false)
    private GeneralReceipt generalReceipt;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(nullable = false)
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneralReceipt getGeneralReceipt() {
        return generalReceipt;
    }

    public void setGeneralReceipt(GeneralReceipt generalReceipt) {
        this.generalReceipt = generalReceipt;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
