package com.school.things.controllers;

import com.school.things.entities.school.SchoolServicesList;
import com.school.things.services.SchoolServicesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school-services-list")
public class SchoolServicesListController {

    @Autowired
    private SchoolServicesListService schoolServicesListService;

    @GetMapping
    public List<SchoolServicesList> getAllServicesListItems() {
        return schoolServicesListService.getAllServicesListItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolServicesList> getServiceListItemById(@PathVariable Long id) {
        Optional<SchoolServicesList> serviceList = schoolServicesListService.getServiceListItemById(id);
        return serviceList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SchoolServicesList> createServiceListItem(@RequestBody SchoolServicesList schoolServicesList) {
        SchoolServicesList createdSchoolServicesList = schoolServicesListService.createServiceListItem(schoolServicesList);
        return ResponseEntity.ok(createdSchoolServicesList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolServicesList> updateServiceListItem(@PathVariable Long id, @RequestBody SchoolServicesList schoolServicesList) {
        SchoolServicesList updatedSchoolServicesList = schoolServicesListService.updateServiceListItem(id, schoolServicesList);
        return ResponseEntity.ok(updatedSchoolServicesList);
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
