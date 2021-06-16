package com.team.services;

import com.team.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person getPersonbyEmail(String email);

    void savePerson(Person person);

    void deleteEmployee(String email);

    void changePerson(String email);

    void update(Person person);
}
