package com.school.things.controllers;

import com.school.things.entities.school.SchoolServiceList;
import com.school.things.services.SchoolServicesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/school/services/list")
public class SchoolServicesListController {

    @Autowired
    private SchoolServicesListService schoolServicesListService;

    @GetMapping
    public List<SchoolServiceList> getAllServicesListItems() {
        return schoolServicesListService.getAllServicesListItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolServiceList> getServiceListItemById(@PathVariable Long id) {
        Optional<SchoolServiceList> serviceList = schoolServicesListService.getServiceListItemById(id);
        return serviceList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SchoolServiceList> createServiceListItem(@RequestBody SchoolServiceList schoolServiceList) {
        SchoolServiceList createdSchoolServiceList = schoolServicesListService.createServiceListItem(schoolServiceList);
        return ResponseEntity.ok(createdSchoolServiceList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolServiceList> updateServiceListItem(@PathVariable Long id, @RequestBody SchoolServiceList schoolServiceList) {
        SchoolServiceList updatedSchoolServiceList = schoolServicesListService.updateServiceListItem(id, schoolServiceList);
        return ResponseEntity.ok(updatedSchoolServiceList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceListItem(@PathVariable Long id) {
        boolean deleted = schoolServicesListService.deleteServiceListItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
