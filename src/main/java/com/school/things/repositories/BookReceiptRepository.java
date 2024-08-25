package com.school.things.repositories;

import com.school.things.entities.BookReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReceiptRepository extends JpaRepository<BookReceipt, Long> {
}
