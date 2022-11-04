package fr.diginamic.bestioles.controllers;

import fr.diginamic.bestioles.entities.Species;
import fr.diginamic.bestioles.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("species")
public class SpeciesController {

    private final String path = "species/";

    @Autowired
    private SpeciesService speciesService;

    @GetMapping()
    public String listSpecies(Model model) {
        List<Species> speciesList = speciesService.findAll();
        model.addAttribute("speciesList", speciesList);
//        speciesList.forEach(System.out::println);
        return path + "list_species";
    }

    @GetMapping("{id}")
    public String itemSpecies(@PathVariable("id") Integer id, Model model) {
        Species species = speciesService.findById(id);
        List<Species> speciesList = List.of(species);
        model.addAttribute("speciesList", speciesList);
//        speciesList.forEach(System.out::println);
        return path + "list_species";
    }

    @GetMapping("create")
    public String createSpecies(Model model) {
        model.addAttribute("speciesItem", new Species());
        return path + "species_create";
    }
}
