package fr.diginamic.bestioles.rest_controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("rest/admin")
    public String  admin() {
        return "Hello admin !";
    }
}
