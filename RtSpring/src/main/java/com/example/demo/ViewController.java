package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/user")
    public String welcomeUserPage(Model model) {
        model.addAttribute("personne", new Personne());
        model.addAttribute("validationErrors", new ArrayList<String>());
        return "view";
    }

    @PostMapping("/user")
    public String welcomeUser(
            @Valid @ModelAttribute("personne") Personne personne, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("validationErrors", result);
            return "view";
        }
        else {
            String welcomeMessage = "Bienvenue, " + personne.getName() + "! Vous avez " + personne.getAge() + " ans.";
            model.addAttribute("welcomeMessage", welcomeMessage);
            model.addAttribute("validationErrors", getValidationErrors(result));
            return "view";qfq
        }
    }

    private List<String> getValidationErrors(BindingResult result) {
        List<String> errors = new ArrayList<>();
        result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        return errors;
    }
}

