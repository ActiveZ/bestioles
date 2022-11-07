package fr.diginamic.bestioles.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Page d'accueil = liste des personnes
     * @return
     */
    @GetMapping
    public String redirectToPersonList() {
        return "redirect:/person";
    }
}
