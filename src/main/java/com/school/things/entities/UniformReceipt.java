package com.school.things.entities;

import com.school.things.entities.items.UniformReceiptItem;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class UniformReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "received_at", updatable = false)
    private Date receivedAt;

    @OneToMany(mappedBy = "uniformReceipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UniformReceiptItem> items;

    // Геттеры и сеттеры

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

    public List<UniformReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<UniformReceiptItem> items) {
        this.items = items;
    }
}
