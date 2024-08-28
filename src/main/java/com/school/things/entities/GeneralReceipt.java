package com.school.things.entities;

import com.school.things.entities.items.GeneralReceiptItem;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class GeneralReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "received_at", updatable = false)
    private Date receivedAt;

    @OneToMany(mappedBy = "generalReceipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeneralReceiptItem> items;

    @ManyToOne
    @JoinColumn(name = "storekeeper_id", nullable = false)
    private Storekeeper storekeeper;

    @PrePersist
    protected void onReceive() {
        this.receivedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public List<GeneralReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<GeneralReceiptItem> items) {
        this.items = items;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }
}
