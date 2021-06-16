package com.team.dao;

import com.team.entity.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPersons();

    Person getPersonbyEmail(String email);

    void savePerson(Person person);

    void deleteEmployee(String email);

    void changePerson(String email);

    void update(Person person);
}
