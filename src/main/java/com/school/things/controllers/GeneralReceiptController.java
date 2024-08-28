package com.school.things.controllers;

import com.school.things.entities.GeneralReceipt;
import com.school.things.entities.items.*;
import com.school.things.requests.GeneralReceiptRequest;
import com.school.things.services.GeneralReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/general-receipts")
public class GeneralReceiptController {

    @Autowired
    private GeneralReceiptService generalReceiptService;

    @GetMapping
    public ResponseEntity<List<GeneralReceipt>> getAllReceipts() {
        List<GeneralReceipt> receipts = generalReceiptService.getAllReceipts();
        return ResponseEntity.ok(receipts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralReceipt> getReceiptById(@PathVariable Long id) {
        GeneralReceipt receipt = generalReceiptService.getReceiptById(id);
        return ResponseEntity.ok(receipt);
    }

    @PostMapping
    public ResponseEntity<GeneralReceipt> createReceipt(@RequestBody GeneralReceiptRequest request) {
        List<GeneralReceiptItem> items = request.getItems().stream().map(itemRequest -> {
            GeneralReceiptItem item = new GeneralReceiptItem();
            item.setQuantity(itemRequest.getQuantity());

            switch (itemRequest.getItemType().toLowerCase()) {
                case "books":
                    Books book = new Books();
                    book.setId(itemRequest.getItemId());
                    item.setBook(book);
                    break;
                case "pants":
                    Pants pants = new Pants();
                    pants.setId(itemRequest.getItemId());
                    item.setPants(pants);
                    break;
                case "shirt":
                    Shirt shirt = new Shirt();
                    shirt.setId(itemRequest.getItemId());
                    item.setShirt(shirt);
                    break;
                case "skirt":
                    Skirt skirt = new Skirt();
                    skirt.setId(itemRequest.getItemId());
                    item.setSkirt(skirt);
                    break;
                case "shorts":
                    Shorts shorts = new Shorts();
                    shorts.setId(itemRequest.getItemId());
                    item.setShorts(shorts);
                    break;
                default:
                    throw new RuntimeException("Unsupported item type: " + itemRequest.getItemType());
            }
            return item;
        }).toList();

        GeneralReceipt receipt = generalReceiptService.createGeneralReceipt(request.getStorekeeperId(), items);
        return ResponseEntity.ok(receipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralReceipt> updateReceipt(@PathVariable Long id, @RequestBody GeneralReceipt updatedReceipt) {
        GeneralReceipt receipt = generalReceiptService.updateReceipt(id, updatedReceipt);
        return ResponseEntity.ok(receipt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Long id) {
        generalReceiptService.deleteReceipt(id);
        return ResponseEntity.noContent().build();
    }
}
