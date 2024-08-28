package com.school.things.entities.items;

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
    private Books book;

    @ManyToOne
    @JoinColumn(name = "pants_id")
    private Pants pants;

    @ManyToOne
    @JoinColumn(name = "shirt_id")
    private Shirt shirt;

    @ManyToOne
    @JoinColumn(name = "skirt_id")
    private Skirt skirt;

    @ManyToOne
    @JoinColumn(name = "shorts_id")
    private Shorts shorts;

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

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    public Skirt getSkirt() {
        return skirt;
    }

    public void setSkirt(Skirt skirt) {
        this.skirt = skirt;
    }

    public Shorts getShorts() {
        return shorts;
    }

    public void setShorts(Shorts shorts) {
        this.shorts = shorts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
