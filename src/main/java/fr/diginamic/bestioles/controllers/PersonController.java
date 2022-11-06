package fr.diginamic.bestioles.controllers;

import fr.diginamic.bestioles.entities.Person;
import fr.diginamic.bestioles.services.PersonService;
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
@RequestMapping("person")
public class PersonController {

    private final String path = "person/";

    @Autowired
    private PersonService personService;

    @GetMapping()
    public String listPerson(Model model) {
        List<Person> personList = personService.findAll();
        model.addAttribute("personList", personList);
        return path + "list_person";
    }

    @GetMapping("{id}")
    public String itemPerson(@PathVariable("id") Integer id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return path + "person_create";
    }

    @GetMapping("create")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return path + "person_create";
    }

    @PostMapping
    public String createOrUpdate(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return path + "person_create";
        }
        personService.createOrUpdate(person);
        return "redirect:/person";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer personId) {
        personService.delete(personId);
        return "redirect:/person";
    }
}
