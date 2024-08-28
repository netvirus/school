package com.school.things.services;

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

    @Autowired
    private PantsRepository pantsRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private SkirtRepository skirtRepository;

    @Autowired
    private ShortsRepository shortsRepository;

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
                Books book = booksRepository.findById(item.getBook().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Book not found"));
                item.setBook(book);
            } else if (item.getPants() != null) {
                Pants pants = pantsRepository.findById(item.getPants().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Pants not found"));
                item.setPants(pants);
            } else if (item.getShirt() != null) {
                Shirt shirt = shirtRepository.findById(item.getShirt().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Shirt not found"));
                item.setShirt(shirt);
            } else if (item.getSkirt() != null) {
                Skirt skirt = skirtRepository.findById(item.getSkirt().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Skirt not found"));
                item.setSkirt(skirt);
            } else if (item.getShorts() != null) {
                Shorts shorts = shortsRepository.findById(item.getShorts().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Shorts not found"));
                item.setShorts(shorts);
            }
            item.setExpenseReceipt(receipt);
        }

        return expenseReceiptRepository.save(receipt);
    }
}
