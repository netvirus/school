package com.school.things.services;

import com.school.things.repositories.SchoolServiceListRepository;
import com.school.things.entities.school.SchoolServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServicesListService {

    @Autowired
    private SchoolServiceListRepository schoolServiceListRepository;

    public List<SchoolServiceList> getAllServicesListItems() {
        return schoolServiceListRepository.findAll();
    }

    public Optional<SchoolServiceList> getServiceListItemById(Long id) {
        return schoolServiceListRepository.findById(id);
    }

    public SchoolServiceList createServiceListItem(SchoolServiceList schoolServiceList) {
        return schoolServiceListRepository.save(schoolServiceList);
    }

    public SchoolServiceList updateServiceListItem(Long id, SchoolServiceList updatedSchoolServiceList) {
        return schoolServiceListRepository.findById(id).map(existingSchoolServicesList -> {
            existingSchoolServicesList.setServiceName(updatedSchoolServiceList.getServiceName());
            return schoolServiceListRepository.save(existingSchoolServicesList);
        }).orElseThrow(() -> new RuntimeException("Services List Item isn't found by id " + id));
    }

    public boolean deleteServiceListItem(Long id) {
        if (schoolServiceListRepository.existsById(id)) {
            schoolServiceListRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
