package com.team.controllers;


import com.team.entity.ChangedEmail;
import com.team.entity.Person;
import com.team.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FirstController {
    @Autowired
    PersonService personService;
    @GetMapping("/contacts")
    public List<Person> getAllContacts() {
    return personService.getAllPersons();
}

    @PostMapping("/contacts")
      public void saveContact(@RequestBody Person person) {
        personService.savePerson(person);
    }

    @GetMapping("/contacts/{email}")
    public Person getContactByEmail(@PathVariable String email) {
       return personService.getPersonbyEmail(email);
    }

    @DeleteMapping("/contacts/{email}")
    public void deleteContactByEmail(@PathVariable String email) {
          personService.deleteEmployee(email);
    }

    @PatchMapping("/contacts/{email}")

    public Person changeContactMail(@PathVariable String email, @RequestBody ChangedEmail changedEmail) {
        Person person = getContactByEmail(email);
        person.setEmail(changedEmail.getEmail());
         personService.update(person);
        return person;
    }

}
