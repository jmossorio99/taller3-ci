package com.ossorio.barrera.taller4.controller.implementation;

import com.ossorio.barrera.taller4.delegate.implementation.ContactfenceDelegateImpl;
import com.ossorio.barrera.taller4.delegate.interfaces.ContactfenceDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.PersonDelegate;
import com.ossorio.barrera.taller4.delegate.interfaces.PersonFenceDelegate;
import com.ossorio.barrera.taller4.model.PersonFence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("contactfences", contactfenceDelegate.findAll());
        model.addAttribute("persons", personDelegate.findAll());
        return "personfence/add";
    }

    @PostMapping("/personfence/add")
    public String addPersonFence(@RequestParam(value="action", required = true) String action, @Validated @ModelAttribute PersonFence pf, BindingResult bindingResult, Model model){
        if(!action.equals("Cancel")){
            if(bindingResult.hasErrors()){
                model.addAttribute("persons", personDelegate.findAll());
                return "personfence/add";
            }
            personFenceDelegate.save(pf);
        }
        return "redirect:/personfence/";
    }
}
