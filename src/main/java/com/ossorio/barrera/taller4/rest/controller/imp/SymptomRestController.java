package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Symptom;
import com.ossorio.barrera.taller4.service.interfaces.SymptomService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/symptoms")
public class SymptomRestController {

    private final SymptomService symptomService;

    public SymptomRestController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping("/{id}")
    public Symptom findById(@PathVariable("id") Long id){
        return symptomService.findById(id);
    }

    @GetMapping
    public Iterable<Symptom> findAll(){
        return symptomService.findAll();
    }

    @PostMapping
    public Symptom save(@RequestBody Symptom symptom){
        return symptomService.save(symptom);
    }

    @DeleteMapping
    public void delete(@RequestBody Symptom symptom){
        symptomService.delete(symptom);
    }

}
