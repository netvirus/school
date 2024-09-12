package com.school.things.controllers;

import com.school.things.entities.pricelist.BasePrice;
import com.school.things.services.BasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/base-prices")
public class BasePriceController {

    @Autowired
    private BasePriceService basePriceService;

    @GetMapping
    public List<BasePrice> getAllBasePrices() {
        return basePriceService.getAllBasePrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasePrice> getBasePriceById(@PathVariable Long id) {
        Optional<BasePrice> basePrice = basePriceService.getBasePriceById(id);
        return basePrice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BasePrice createBasePrice(@RequestBody BasePrice basePrice) {
        return basePriceService.saveBasePrice(basePrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasePrice> updateBasePrice(@PathVariable Long id, @RequestBody BasePrice basePrice) {
        return ResponseEntity.ok(basePriceService.updateBasePrice(id, basePrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasePrice(@PathVariable Long id) {
        basePriceService.deleteBasePrice(id);
        return ResponseEntity.noContent().build();
    }
}
