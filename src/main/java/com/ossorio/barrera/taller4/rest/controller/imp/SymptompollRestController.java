package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Symptompoll;
import com.ossorio.barrera.taller4.service.interfaces.SymptompollService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class SymptompollRestController {

    private final SymptompollService symptompollService;

    public SymptompollRestController(SymptompollService symptompollService) {
        this.symptompollService = symptompollService;
    }

    @GetMapping
    public List<Symptompoll> getAll() {
        return symptompollService.findAll();
    }

    @GetMapping("/{id}")
    public Symptompoll findById(@PathVariable("id") Long id) {
        return symptompollService.findById(id);
    }

    @GetMapping("/find-by-date")
    public List<Symptompoll> findByDate(
            @RequestParam(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return symptompollService.findByDate(startDate, endDate);
    }

    @GetMapping("/find-by-date-ordered")
    public List<Symptompoll> findByDateOrdered(@RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return symptompollService.findByDateOrdered(date);
    }

    @GetMapping("/zero-questions")
    public List<Symptompoll> listZeroWeightQuestions() {
        return symptompollService.listZeroWeightQuestions();
    }

    @PostMapping
    public Symptompoll add(@RequestBody Symptompoll symptompoll) {
        return symptompollService.save(symptompoll, symptompoll.getInstInstId(),
                symptompoll.getEpidemevent().getEpieveId());
    }

    @PutMapping
    public Symptompoll update(@RequestBody Symptompoll symptompoll) {
        return symptompollService.update(symptompoll, symptompoll.getInstInstId(),
                symptompoll.getEpidemevent().getEpieveId());
    }

    @DeleteMapping
    public void delete(@RequestBody Symptompoll symptompoll) {
        symptompollService.delete(symptompoll);
    }

}
