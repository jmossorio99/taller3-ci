package com.ossorio.barrera.taller4.rest.controller.imp;

import com.ossorio.barrera.taller4.model.Epidemevent;
import com.ossorio.barrera.taller4.service.interfaces.EpidemeventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epidemevent")
public class EpidemeventRestController {

    private final EpidemeventService epidemeventService;

    public EpidemeventRestController(EpidemeventService epidemeventService) {
        this.epidemeventService = epidemeventService;
    }

    @GetMapping("/{id}")
    public Epidemevent findById(@PathVariable("id") Long id){
        return epidemeventService.findById(id);
    }

    @GetMapping
    public List<Epidemevent> findAll(){
        return epidemeventService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestBody Epidemevent epidemevent){
        epidemeventService.delete(epidemevent);
    }

    @PostMapping
    public Epidemevent save(@RequestBody Epidemevent epidemevent){
        return epidemeventService.save(epidemevent);
    }

}
