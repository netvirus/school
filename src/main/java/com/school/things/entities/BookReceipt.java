package com.school.things.entities;

import com.school.things.entities.items.BookReceiptItem;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class BookReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "received_at", updatable = false)
    private Date receivedAt;

    @OneToMany(mappedBy = "bookReceipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookReceiptItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    @PrePersist
    protected void onReceive() {
        this.receivedAt = new Date();
    }

    public List<BookReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<BookReceiptItem> items) {
        this.items = items;
    }
}
