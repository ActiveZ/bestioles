package fr.diginamic.bestioles.controllers;

import fr.diginamic.bestioles.entities.Animal;
import fr.diginamic.bestioles.enums.Sex;
import fr.diginamic.bestioles.repositories.SpeciesRepository;
import fr.diginamic.bestioles.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
@RequestMapping("animal")
public class AnimalController {

    private final String path = "animal/";
    @Autowired
    private AnimalService animalService;

    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping()
    public String listAnimal(Model model) {
        List<Animal> animalList = animalService.findAll();
        model.addAttribute("animalList", animalList);
        return path + "list_animal";
    }

    @GetMapping("{id}")
    public String itemAnimal(@PathVariable("id") Integer id, Model model) {
        Animal animal = animalService.findById(id);
        model.addAttribute("animal", animal);
        model.addAttribute("speciesList", speciesRepository.findAll(Sort.by(Sort.Direction.ASC, "commonName")));
        model.addAttribute("sexList", List.of(Sex.values()));
        return path + "animal_create";
    }

    @GetMapping("create")
    public String createAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("speciesList", speciesRepository.findAll(Sort.by(Sort.Direction.ASC, "commonName")));
        model.addAttribute("sexList", List.of(Sex.values()));
        return path + "animal_create";
    }

    @PostMapping
    public String createOrUpdate(@Valid Animal animal, BindingResult result) {
        if (result.hasErrors()) {
            return path + "animal_create";
        }
        animalService.createOrUpdate(animal);
        return "redirect:/animal";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer animalId) {
        animalService.delete(animalId);
        return "redirect:/animal";
    }
}
