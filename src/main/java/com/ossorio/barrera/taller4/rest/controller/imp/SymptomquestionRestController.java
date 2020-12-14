package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Symptomquestion;
import com.ossorio.barrera.taller4.service.interfaces.SymptomquestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class SymptomquestionRestController {

    private final SymptomquestionService symptomquestionService;

    public SymptomquestionRestController(SymptomquestionService symptomquestionService) {
        this.symptomquestionService = symptomquestionService;
    }

    @GetMapping
    public List<Symptomquestion> getAll() {
        return symptomquestionService.findAll();
    }

    @GetMapping("/{id}")
    public Symptomquestion findById(@PathVariable Long id) {
        return symptomquestionService.findById(id);
    }

    @PostMapping
    public Symptomquestion add(@RequestBody Symptomquestion symptomquestion){
        return symptomquestionService.save(symptomquestion);
    }

    @PutMapping
    public Symptomquestion update(@RequestBody Symptomquestion symptomquestion){
        return symptomquestionService.update(symptomquestion, symptomquestion.getSymptom().getSympId(),
                symptomquestion.getSymptompoll().getSympollId());
    }

    @DeleteMapping
    public void delete(@RequestBody Symptomquestion symptomquestion){
        symptomquestionService.delete(symptomquestion);
    }



}
