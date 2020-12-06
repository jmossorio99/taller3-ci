package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Sympweightbyday;
import com.ossorio.barrera.taller4.service.interfaces.SympweightbydayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weights")
public class SymptomWeightRestController {

    private final SympweightbydayService sympweightbydayService;

    public SymptomWeightRestController(SympweightbydayService sympweightbydayService){
        this.sympweightbydayService = sympweightbydayService;
    }

    @GetMapping
    public List<Sympweightbyday> getAll(){
        return sympweightbydayService.findAll();
    }

    @GetMapping("/{id}")
    public Sympweightbyday findById(@PathVariable Long id){
        return sympweightbydayService.findById(id);
    }

    @PostMapping
    public Sympweightbyday add(@RequestBody Sympweightbyday sympweightbyday){
        return sympweightbydayService.save(sympweightbyday,
                sympweightbyday.getSymptomquestion().getSympquesId());
    }

    @PutMapping
    public Sympweightbyday update(@RequestBody Sympweightbyday sympweightbyday){
        return sympweightbydayService.update(sympweightbyday,
                sympweightbyday.getSymptomquestion().getSympquesId());
    }

    @DeleteMapping
    public void delete(@RequestBody Sympweightbyday sympweightbyday){
        sympweightbydayService.delete(sympweightbyday);
    }
}
