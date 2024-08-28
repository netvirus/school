package com.school.things.repositories;

import com.school.things.entities.ExpenseReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseReceiptRepository extends JpaRepository<ExpenseReceipt, Long> {
    @Query("SELECT SUM(item.quantity) FROM ExpenseReceiptItem item WHERE item.book.id = :bookId")
    int sumIssuedBooks(@Param("bookId") Long bookId);
}
