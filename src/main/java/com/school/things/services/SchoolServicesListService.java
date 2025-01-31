package com.school.things.services;

import com.school.things.repositories.SchoolServicesListRepository;
import com.school.things.entities.school.SchoolServicesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServicesListService {

    @Autowired
    private SchoolServicesListRepository schoolServicesListRepository;

    public List<SchoolServicesList> getAllServicesListItems() {
        return schoolServicesListRepository.findAll();
    }

    public Optional<SchoolServicesList> getServiceListItemById(Long id) {
        return schoolServicesListRepository.findById(id);
    }

    public SchoolServicesList createServiceListItem(SchoolServicesList schoolServicesList) {
        return schoolServicesListRepository.save(schoolServicesList);
    }

    public SchoolServicesList updateServiceListItem(Long id, SchoolServicesList updatedSchoolServicesList) {
        return schoolServicesListRepository.findById(id).map(existingSchoolServicesList -> {
            existingSchoolServicesList.setServiceName(updatedSchoolServicesList.getServiceName());
            return schoolServicesListRepository.save(existingSchoolServicesList);
        }).orElseThrow(() -> new RuntimeException("Services List Item isn't found by id " + id));
    }

    public boolean deleteServiceListItem(Long id) {
        if (schoolServicesListRepository.existsById(id)) {
            schoolServicesListRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
