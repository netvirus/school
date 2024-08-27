package com.school.things.utils;

import com.school.things.entities.abstracts.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDataCopier {

    public void copyCommonPersonData(Person existingPerson, Person newPerson) {
        existingPerson.setFirstName(newPerson.getFirstName());
        existingPerson.setLastName(newPerson.getLastName());
        existingPerson.setAge(newPerson.getAge());
        existingPerson.setGender(newPerson.getGender());
        existingPerson.setNationality(newPerson.getNationality());
        existingPerson.setPhoneNumber(newPerson.getPhoneNumber());
        existingPerson.setAddress(newPerson.getAddress());
    }
}
