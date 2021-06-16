package com.team.dao;

import com.team.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOimpl implements PersonDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Person> getAllPersons() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> allPersons = session.createQuery("from Person", Person.class).getResultList();
        return allPersons;
    }

    @Override
    public Person getPersonbyEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Person person =
                session.createQuery("from Person where email = ?1", Person.class).setParameter(1, email).getSingleResult();

        return person;
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
    }

    @Override
    public void deleteEmployee(String email) {
        Session session = sessionFactory.getCurrentSession();
        Person person =
                session.createQuery("from Person where email = ?1", Person.class).setParameter(1, email).getSingleResult();

        session.delete(person);
    }

    @Override
    public void changePerson(String email) {
        Session session = sessionFactory.getCurrentSession();
        Person person =
                session.createQuery("from Person where email = ?1", Person.class).setParameter(1, email).getSingleResult();
        person.setEmail(email);

         savePerson(person);
    }

    @Override
    public void update(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
    }
}
