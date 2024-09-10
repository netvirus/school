package com.school.things.services;

import com.school.things.entities.Book;
import com.school.things.entities.ExpenseReceipt;
import com.school.things.entities.Storekeeper;
import com.school.things.entities.items.*;
import com.school.things.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseReceiptService {

    @Autowired
    private ExpenseReceiptRepository expenseReceiptRepository;

    @Autowired
    private StorekeeperRepository storekeeperRepository;

    @Autowired
    private BooksRepository booksRepository;

    public List<ExpenseReceipt> getAllReceipts() {
        return expenseReceiptRepository.findAll();
    }

    public Optional<ExpenseReceipt> getReceiptById(Long id) {
        return expenseReceiptRepository.findById(id);
    }

    public ExpenseReceipt createReceipt(ExpenseReceipt receipt) {
        return expenseReceiptRepository.save(receipt);
    }

    public ExpenseReceipt updateReceipt(Long id, ExpenseReceipt updatedReceipt) {
        return expenseReceiptRepository.findById(id)
                .map(receipt -> {
                    receipt.setStorekeeper(updatedReceipt.getStorekeeper());
                    receipt.setItems(updatedReceipt.getItems());
                    return expenseReceiptRepository.save(receipt);
                })
                .orElseThrow(() -> new EntityNotFoundException("ExpenseReceipt not found"));
    }

    public void deleteReceipt(Long id) {
        expenseReceiptRepository.deleteById(id);
    }

    public ExpenseReceipt createExpenseReceipt(Long storekeeperId, List<ExpenseReceiptItem> items) {
        Storekeeper storekeeper = storekeeperRepository.findById(storekeeperId)
                .orElseThrow(() -> new EntityNotFoundException("Storekeeper not found"));

        ExpenseReceipt receipt = new ExpenseReceipt();
        receipt.setStorekeeper(storekeeper);
        receipt.setItems(items);

        for (ExpenseReceiptItem item : items) {
            if (item.getBook() != null) {
                Book book = booksRepository.findById(item.getBook().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Book not found"));
                item.setBook(book);
            }
            item.setExpenseReceipt(receipt);
        }

        return expenseReceiptRepository.save(receipt);
    }
}
