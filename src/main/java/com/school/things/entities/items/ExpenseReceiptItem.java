package com.school.things.entities.items;

import com.school.things.entities.Book;
import com.school.things.entities.ExpenseReceipt;
import jakarta.persistence.*;

@Entity
public class ExpenseReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_receipt_id", nullable = false)
    private ExpenseReceipt expenseReceipt;

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

    public ExpenseReceipt getExpenseReceipt() {
        return expenseReceipt;
    }

    public void setExpenseReceipt(ExpenseReceipt expenseReceipt) {
        this.expenseReceipt = expenseReceipt;
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
