package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.UsvInstitution;
import com.ossorio.barrera.taller4.service.interfaces.UsvInstitutionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institutions")
public class UsvInstitutionRestController {

    private final UsvInstitutionService institutionService;

    public UsvInstitutionRestController(UsvInstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping()
    public List<UsvInstitution> getAll() {
        return institutionService.findAll();
    }

    @GetMapping("/{id}")
    public UsvInstitution findById(@PathVariable Long id) {
        return institutionService.findById(id);
    }

    @GetMapping("/{name}")
    public UsvInstitution findByName(@PathVariable String name){
        return institutionService.findByName(name);
    }

    @PostMapping
    public UsvInstitution save(@RequestBody UsvInstitution institution) {
        return institutionService.save(institution);
    }

    @PutMapping()
    public UsvInstitution update(@RequestBody UsvInstitution institution){
        return institutionService.update(institution);
    }

    @DeleteMapping
    public void delete(@RequestBody UsvInstitution institution){
        institutionService.delete(institution);
    }

}
