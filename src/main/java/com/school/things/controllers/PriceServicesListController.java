package com.school.things.controllers;

import com.school.things.entities.school.PriceServicesList;
import com.school.things.entities.school.SchoolServicesList;
import com.school.things.services.PriceServicesListService;
import com.school.things.services.SchoolServicesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/price-services-list")
public class PriceServicesListController {

    @Autowired
    private PriceServicesListService priceServicesListService;

    @GetMapping
    public List<PriceServicesList> getAllServicesListItems() {
        return priceServicesListService.getAllServicesLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceServicesList> getServiceListItemById(@PathVariable Long id) {
        Optional<PriceServicesList> priceServiceList = priceServicesListService.getPriceServiceListById(id);
        return priceServiceList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PriceServicesList> createPriceServiceList(@RequestBody PriceServicesList priceServicesList) {
        PriceServicesList createdSchoolServicesList = priceServicesListService.createPriceServiceList(priceServicesList);
        return ResponseEntity.ok(createdSchoolServicesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceServicesList> updatePriceServiceList(@PathVariable Long id, @RequestBody PriceServicesList priceServicesList) {
        PriceServicesList updatedSchoolServicesList = priceServicesListService.updatePriceServiceList(id, priceServicesList);
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
