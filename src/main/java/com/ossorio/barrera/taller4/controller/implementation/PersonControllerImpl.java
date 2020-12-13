package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.interfaces.PersonDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.UsvInstitutionDelegate;
import com.ossorio.barrera.taller4.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonControllerImpl {

    private final PersonDelegate personDelegate;
    private final UsvInstitutionDelegate usvInstitutionDelegate;

    public PersonControllerImpl(PersonDelegate personDelegate, UsvInstitutionDelegate usvInstitutionDelegate) {
        this.personDelegate = personDelegate;
        this.usvInstitutionDelegate = usvInstitutionDelegate;
    }

    @GetMapping("/person")
    public String indexPersons(Model model) {
        model.addAttribute("persons", personDelegate.findAll());
        return "person/index";
    }

    @GetMapping("/person/add")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("institutions", usvInstitutionDelegate.getAll());
        return "person/add";
    }

    @PostMapping("/person/add")
    public String addPersonPost(@RequestParam(value = "action", required = true) String action,
                                @Validated @ModelAttribute Person person, BindingResult bindingResult, Model model) {
        if (!action.equals("Cancel")) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("institutions", usvInstitutionDelegate.getAll());
                return "person/add";
            }
            personDelegate.save(person);
        }
        return "redirect:/person/";
    }

    @GetMapping("/person/edit/{id}")
    public String updatePerson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personDelegate.findById(id));
        model.addAttribute("institutions", usvInstitutionDelegate.getAll());
        return "person/edit";
    }

    @PostMapping("/person/edit/{id}")
    public String updatePersonPost(@RequestParam(value = "action", required = true) String action, @PathVariable("id") long id,
                                   @Validated @ModelAttribute Person person, BindingResult bindingResult, Model model) {
        if (!action.equals("cancel")) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("institutions", usvInstitutionDelegate.getAll());
                return "person/edit";
            }
            person.setPersId(id);
            personDelegate.update(person);
        }
        return "redirect:/person/";
    }

    @PostMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") long id, Model model){
        personDelegate.delete(personDelegate.findById(id));
        return "redirect:/person/";
    }

}
