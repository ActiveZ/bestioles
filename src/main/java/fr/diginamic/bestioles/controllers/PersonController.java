package fr.diginamic.bestioles.controllers;

import fr.diginamic.bestioles.entities.Person;
import fr.diginamic.bestioles.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Person> personList = List.of(person);
        model.addAttribute("personList", personList);
        return path + "list_person";
    }

    @GetMapping("create")
    public String createPerson(Model model) {
        model.addAttribute("personItem", new Person());
        return path + "person_create";
    }

    @PostMapping
    public String createOrUpdate(Person personItem) {
        personService.createOrUpdate(personItem);
        return "redirect:/person";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer personId) {
        personService.delete(personId);
        return "redirect:/person";
    }
}
