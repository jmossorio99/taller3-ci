package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.PersonFence;
import com.ossorio.barrera.taller4.service.interfaces.PersonFenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personfences")
public class PersonFenceRestController {

    private final PersonFenceService personFenceService;

    public PersonFenceRestController(PersonFenceService personFenceService){
        this.personFenceService = personFenceService;
    }

    @GetMapping
    public List<PersonFence> findAll(){
        return personFenceService.findAll();
    }

    @GetMapping("{id}")
    public PersonFence findById(@PathVariable("id") Long id){
        return personFenceService.findById(id);
    }

    @PostMapping
    public PersonFence save(@RequestBody PersonFence personFence){
        return personFenceService.save(personFence);
    }

    @PutMapping
    public PersonFence update(@RequestBody PersonFence personFence){
        return personFenceService.update(personFence);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        personFenceService.delete(personFenceService.findById(id));
    }
}
