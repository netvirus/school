package com.school.things.controllers;

import com.school.things.entities.pricelist.Prices;
import com.school.things.services.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PricesController {

    @Autowired
    private PricesService pricesService;

    @GetMapping
    public List<Prices> getAllPrices() {
        return pricesService.getAllPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prices> getPriceById(@PathVariable Long id) {
        Optional<Prices> price = pricesService.getPriceById(id);
        return price.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prices> createPrice(@RequestBody Prices prices) {
        Prices createdPrice = pricesService.createPrice(prices);
        return ResponseEntity.ok(createdPrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prices> updatePrice(@PathVariable Long id, @RequestBody Prices prices) {
        Prices updatedPrice = pricesService.updatePrice(id, prices);
        return ResponseEntity.ok(updatedPrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        boolean deleted = pricesService.deletePrice(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
