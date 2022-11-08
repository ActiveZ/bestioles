package fr.diginamic.bestioles.rest_controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("rest/public")
    public String pub() {
        return "Hello public !";
    }
}
