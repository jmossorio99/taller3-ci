package com.ossorio.barrera.taller4.dao.interfaces;

import com.ossorio.barrera.taller4.model.Person;

import java.util.List;

public interface PersonDao {

    Person save(Person person);

    Person update(Person person);

    void delete(Person person);

    List<Person> findAll();

    Person findById(Long id);

}
