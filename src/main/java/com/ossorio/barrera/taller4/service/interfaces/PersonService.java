package com.ossorio.barrera.taller4.service.interfaces;

import com.ossorio.barrera.taller4.model.Person;

import java.util.List;

public interface PersonService {

    Person save(Person person);

    Person update(Person person);

    void delete(Person person);

    List<Person> findAll();

    Person findById(Long id);

}
