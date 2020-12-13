package com.ossorio.barrera.taller4.delegate.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.PersonDelegate;
import com.ossorio.barrera.taller4.model.Person;
import com.ossorio.barrera.taller4.model.Symptompoll;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class PersonDelegateImpl implements PersonDelegate {

    private final String SERVER = "http://localhost:8081/persons/";
    private final RestTemplate restTemplate;

    public PersonDelegateImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Person save(Person person) {
        return restTemplate.postForEntity(SERVER, person, Person.class).getBody();
    }

    @Override
    public Person update(Person person) {
        restTemplate.put(SERVER, person, Person.class);
        return person;
    }

    @Override
    public void delete(Person person) {
        restTemplate.delete(SERVER, person, Person.class);
    }

    @Override
    public List<Person> findAll() {
        return Arrays.asList(restTemplate.getForObject(SERVER, Person[].class));
    }

    @Override
    public Person findById(Long id) {
        return restTemplate.getForObject(SERVER + id, Person.class);
    }
}
