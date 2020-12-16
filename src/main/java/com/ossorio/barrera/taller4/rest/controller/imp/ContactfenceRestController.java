package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Contactfence;
import com.ossorio.barrera.taller4.service.interfaces.ContactfenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactfences")
public class ContactfenceRestController {

    private final ContactfenceService contactfenceService;

    public ContactfenceRestController(ContactfenceService contactfenceService) {
        this.contactfenceService = contactfenceService;
    }

    @GetMapping("/{id}")
    public Contactfence findById(@PathVariable("id") Long id){
        return contactfenceService.findById(id);
    }

    @GetMapping
    public List<Contactfence> findAll(){
        return contactfenceService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestBody Contactfence cf){
        contactfenceService.delete(cf);
    }

    @PostMapping
    public Contactfence save(@RequestBody Contactfence cf){
        return contactfenceService.save(cf);
    }
}
