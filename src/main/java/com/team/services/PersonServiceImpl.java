package com.team.services;

import com.team.dao.PersonDAO;
import com.team.entity.Person;
import com.team.exceptions.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonDAO personDAO;

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    @Transactional
    public Person getPersonbyEmail(String email) {
        return personDAO.getPersonbyEmail(email);
    }

    @Override
    @Transactional
    public void savePerson(Person person) {

        List<Person> allPersons = getAllPersons();
        for(Person p: allPersons) {
            if(p.getEmail().equals(person.getEmail())) {
              throw  new ConflictException();
            }
        }
     personDAO.savePerson(person);

    }

    @Override
    @Transactional
    public void deleteEmployee(String email) {
      personDAO.deleteEmployee(email);
    }

    @Override
    @Transactional
    public void changePerson(String email) {
   personDAO.changePerson(email);
    }

    @Override
    @Transactional
    public void update(Person person) {
        personDAO.update(person);
    }
}
