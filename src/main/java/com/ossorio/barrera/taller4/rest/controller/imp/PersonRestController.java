package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Person;
import com.ossorio.barrera.taller4.service.interfaces.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id){
        return personService.findById(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping
    public void delete(@RequestBody Person person){
        personService.delete(person);
    }

}
