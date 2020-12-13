package com.ossorio.barrera.taller4.service.implementation;

import com.ossorio.barrera.taller4.dao.interfaces.PersonDao;
import com.ossorio.barrera.taller4.model.Person;
import com.ossorio.barrera.taller4.service.interfaces.PersonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public Person save(Person person) {
        return dao.save(person);
    }

    @Transactional
    @Override
    public Person update(Person person) {
        dao.update(person);
        return person;
    }

    @Transactional
    @Override
    public void delete(Person person) {
        dao.delete(person);
    }

    @Transactional
    @Override
    public List<Person> findAll() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public Person findById(Long id) {
        return dao.findById(id);
    }
}
