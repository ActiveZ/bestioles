package fr.diginamic.bestioles.rest_controllers;

import fr.diginamic.bestioles.dto.UserDTO;
import fr.diginamic.bestioles.entities.User;
import fr.diginamic.bestioles.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("rest/user")
    public String user() {
        return "Hello user !";
    }

    /**
     * dans body raw de Postman:
     *{
     *     "userName":"admin",
     *     "pwd":"admin",
     *     "roles":["admin", "user"]
     * }
     * route public pour la création d'un utilisateur: localhost:8080/rest/new-user
     * @param userDTO
     * @return
     */
    @PostMapping("rest/new-user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO.getUserName(), userDTO.getPwd(), userDTO.getRoles());
    }

//    @PostMapping("rest/new-user")
//    public User createUser(@RequestParam("userName") String username,
//                           @RequestParam("pwd") String pwd) {
//        return userService.createUser(username, pwd, null);
//    }

}
