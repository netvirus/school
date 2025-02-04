package com.school.things.controllers;

import com.school.things.entities.price.PriceServiceList;
import com.school.things.services.PriceServicesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/price/services/list")
public class PriceServicesListController {

    @Autowired
    private PriceServicesListService priceServicesListService;

    @GetMapping
    public List<PriceServiceList> getAllServicesListItems() {
        return priceServicesListService.getAllServicesLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceServiceList> getServiceListItemById(@PathVariable Long id) {
        Optional<PriceServiceList> priceServiceList = priceServicesListService.getPriceServiceListById(id);
        return priceServiceList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PriceServiceList> createPriceServiceList(@RequestBody PriceServiceList priceServiceList) {
        PriceServiceList createdSchoolServicesList = priceServicesListService.createPriceServiceList(priceServiceList);
        return ResponseEntity.ok(createdSchoolServicesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceServiceList> updatePriceServiceList(@PathVariable Long id, @RequestBody PriceServiceList priceServiceList) {
        PriceServiceList updatedSchoolServicesList = priceServicesListService.updatePriceServiceList(id, priceServiceList);
        return ResponseEntity.ok(updatedSchoolServicesList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceServiceList(@PathVariable Long id) {
        boolean deleted = priceServicesListService.deletePriceServiceList(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
