package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.implementation.ContactfenceDelegateImpl;
import com.ossorio.barrera.taller4.delegate.interfaces.ContactfenceDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.PersonDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.PersonFenceDelegate;
import com.ossorio.barrera.taller4.model.PersonFence;
import com.ossorio.barrera.taller4.model.PersonFencePK;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonFenceController {

    private final PersonFenceDelegate personFenceDelegate;
    private final PersonDelegate personDelegate;
    private final ContactfenceDelegate contactfenceDelegate;

    public PersonFenceController(PersonFenceDelegate pfDelegate, PersonDelegate personDelegate, ContactfenceDelegate contactfenceDelegate){
        this.personFenceDelegate = pfDelegate;
        this.personDelegate = personDelegate;
        this.contactfenceDelegate = contactfenceDelegate;
    }

    @GetMapping("/personfence")
    public String indexPersonFence(Model model){
        model.addAttribute("personfences", personFenceDelegate.findAll());
        return "personfence/index";
    }

    @GetMapping("personfence/add")
    public String addPersonFenceGet(Model model){
        model.addAttribute("personfence", new PersonFence());
        model.addAttribute("contactfences", contactfenceDelegate.findAll());
        model.addAttribute("persons", personDelegate.findAll());
        return "personfence/add";
    }

    @PostMapping("/personfence/add")
    public String addPersonFence(@RequestParam(value="action", required = true) String action, @Validated @ModelAttribute PersonFence pf, BindingResult bindingResult, Model model){
        if(!action.equals("Cancel")){
            if (bindingResult.hasErrors()) {
                System.out.println(bindingResult.getAllErrors().toString());
                model.addAttribute("personfence", new PersonFence());
                model.addAttribute("contactfences", contactfenceDelegate.findAll());
                model.addAttribute("persons", personDelegate.findAll());
                return "personfence/add";
            }
            PersonFencePK pk = new PersonFencePK();
            pk.setContfenContfenId(pf.getContactfence().getContfenId());
            pk.setPersPersId(pf.getPerson().getPersId());
            pf.setId(pk);
            personFenceDelegate.save(pf);
        }
        return "redirect:/personfence/";
    }

    @GetMapping("/personfence/edit/{id}")
    public String updatePersonFence(@PathVariable("id") Long id, Model model){
        model.addAttribute("personfence", personFenceDelegate.findById(id));
        model.addAttribute("contactfences", contactfenceDelegate.findAll());
        model.addAttribute("persons", personDelegate.findAll());
        return "personfence/edit";
    }

    @PostMapping("personfence/edit/{id}")
    public String updatePersonFencePost(@RequestParam(value = "action", required = true) String action, @PathVariable("id") long id, @Validated @ModelAttribute PersonFence personfence, BindingResult bindingResult, Model model){
        if(!action.equals("Cancel")){
            if(bindingResult.hasErrors()){
                model.addAttribute("personfence", personFenceDelegate.findById(id));
                model.addAttribute("contactfences", contactfenceDelegate.findAll());
                model.addAttribute("persons", personDelegate.findAll());
                return "personfence/edit";
            }
            personFenceDelegate.update(personfence);
        }
        return "redirect:/person/";
    }

    @PostMapping("/personfence/delete/{id}")
    public String deletePerson(@PathVariable("id") PersonFencePK id, Model model){
        personFenceDelegate.delete(id);
        return "redirect:/person/";
    }
}
