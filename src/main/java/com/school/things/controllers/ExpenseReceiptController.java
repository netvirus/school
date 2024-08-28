package com.school.things.controllers;

import com.school.things.entities.ExpenseReceipt;
import com.school.things.entities.items.ExpenseReceiptItem;
import com.school.things.requests.ExpenseReceiptRequest;
import com.school.things.services.ExpenseReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense-receipts")
public class ExpenseReceiptController {

    @Autowired
    private ExpenseReceiptService expenseReceiptService;

    // Получение всех расходных ордеров
    @GetMapping
    public ResponseEntity<List<ExpenseReceipt>> getAllReceipts() {
        List<ExpenseReceipt> receipts = expenseReceiptService.getAllReceipts();
        return ResponseEntity.ok(receipts);
    }

    // Получение расходного ордера по ID
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseReceipt> getReceiptById(@PathVariable Long id) {
        Optional<ExpenseReceipt> receipt = expenseReceiptService.getReceiptById(id);
        return receipt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Создание нового расходного ордера
    @PostMapping
    public ResponseEntity<ExpenseReceipt> createReceipt(@RequestBody ExpenseReceiptRequest request) {
        List<ExpenseReceiptItem> items = request.getItems().stream().map(itemRequest -> {
            ExpenseReceiptItem item = new ExpenseReceiptItem();
            item.setQuantity(itemRequest.getQuantity());
            // Здесь нужно будет в зависимости от типа предмета заполнить соответствующие поля
            return item;
        }).toList();

        ExpenseReceipt receipt = expenseReceiptService.createExpenseReceipt(request.getStorekeeperId(), items);
        return ResponseEntity.ok(receipt);
    }

    // Обновление существующего расходного ордера
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseReceipt> updateReceipt(@PathVariable Long id, @RequestBody ExpenseReceipt updatedReceipt) {
        ExpenseReceipt receipt = expenseReceiptService.updateReceipt(id, updatedReceipt);
        return ResponseEntity.ok(receipt);
    }

    // Удаление расходного ордера
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Long id) {
        expenseReceiptService.deleteReceipt(id);
        return ResponseEntity.noContent().build();
    }
}
