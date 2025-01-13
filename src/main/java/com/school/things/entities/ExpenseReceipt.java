package com.school.things.entities;

import com.school.things.entities.items.ExpenseReceiptItem;
import com.school.things.entities.student.Student;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ExpenseReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "issued_at", updatable = false)
    private Date issuedAt;

    @OneToMany(mappedBy = "expenseReceipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseReceiptItem> items;

    @ManyToOne
    @JoinColumn(name = "storekeeper_id", nullable = false)
    private Storekeeper storekeeper;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @PrePersist
    protected void onIssue() {
        this.issuedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public List<ExpenseReceiptItem> getItems() {
        return items;
    }

    public void setItems(List<ExpenseReceiptItem> items) {
        this.items = items;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
