package com.school.things.services;

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

    @Autowired
    private PantsRepository pantsRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private SkirtRepository skirtRepository;

    @Autowired
    private ShortsRepository shortsRepository;

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
