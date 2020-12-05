package com.ossorio.barrera.taller4.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossorio.barrera.taller4.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
