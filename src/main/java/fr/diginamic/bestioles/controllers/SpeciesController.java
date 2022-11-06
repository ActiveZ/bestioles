package fr.diginamic.bestioles.controllers;

import fr.diginamic.bestioles.entities.Species;
import fr.diginamic.bestioles.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
        return path + "list_species";
    }

    @GetMapping("{id}")
    public String itemSpecies(@PathVariable("id") Integer id, Model model) {
        Species species = speciesService.findById(id);
        model.addAttribute("species", species);
        return path + "species_create";
    }

    @GetMapping("create")
    public String createSpecies(Model model) {
        model.addAttribute("species", new Species());
        System.out.println("model = " + model);
        return path + "species_create";
    }

    @PostMapping()
    public String createOrUpdate(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return path + "species_create";
        }
        speciesService.createOrUpdate(species);
        return "redirect:/species";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer speciesId) {
        speciesService.delete(speciesId);
        return "redirect:/species";
    }
}
