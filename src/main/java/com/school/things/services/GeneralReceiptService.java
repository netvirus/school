package com.school.things.services;

import com.school.things.entities.Book;
import com.school.things.entities.GeneralReceipt;
import com.school.things.entities.Storekeeper;
import com.school.things.entities.items.*;
import com.school.things.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralReceiptService {

    @Autowired
    private GeneralReceiptRepository generalReceiptRepository;

    @Autowired
    private StorekeeperRepository storekeeperRepository;

    @Autowired
    private BooksRepository booksRepository;

    public List<GeneralReceipt> getAllReceipts() {
        return generalReceiptRepository.findAll();
    }

    public GeneralReceipt getReceiptById(Long id) {
        return generalReceiptRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GeneralReceipt not found"));
    }

    public GeneralReceipt createGeneralReceipt(Long storekeeperId, List<GeneralReceiptItem> items) {
        Storekeeper storekeeper = storekeeperRepository.findById(storekeeperId)
                .orElseThrow(() -> new EntityNotFoundException("Storekeeper not found"));

        GeneralReceipt receipt = new GeneralReceipt();
        receipt.setStorekeeper(storekeeper);
        receipt.setItems(items);

        for (GeneralReceiptItem item : items) {
            if (item.getBook() != null) {
                Book book = booksRepository.findById(item.getBook().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Book not found"));
                item.setBook(book);
            }
            item.setGeneralReceipt(receipt);
        }

        return generalReceiptRepository.save(receipt);
    }

    public GeneralReceipt updateReceipt(Long id, GeneralReceipt updatedReceipt) {
        GeneralReceipt receipt = generalReceiptRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GeneralReceipt not found"));

        receipt.setStorekeeper(updatedReceipt.getStorekeeper());
        receipt.setItems(updatedReceipt.getItems());
        return generalReceiptRepository.save(receipt);
    }

    public void deleteReceipt(Long id) {
        generalReceiptRepository.deleteById(id);
    }
}
