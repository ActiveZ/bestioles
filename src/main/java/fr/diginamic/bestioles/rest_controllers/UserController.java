package fr.diginamic.bestioles.rest_controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("rest/user")
    public String user() {
        return "Hello user !";
    }
}
