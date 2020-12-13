package com.ossorio.barrera.taller4.dao.imp;

import com.ossorio.barrera.taller4.dao.interfaces.PersonDao;
import com.ossorio.barrera.taller4.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonDaoImp implements PersonDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    @Override
    public Person update(Person person) {
        entityManager.merge(person);
        return person;
    }

    @Override
    public void delete(Person person) {
        entityManager.remove(person);
    }

    @Override
    public List<Person> findAll() {
        final String jpql = "SELECT a FROM Person a";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

}
