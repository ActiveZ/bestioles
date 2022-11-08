package fr.diginamic.bestioles.rest_controllers;

import fr.diginamic.bestioles.dto.UserDTO;
import fr.diginamic.bestioles.entities.User;
import fr.diginamic.bestioles.services.UserService;
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
     * dans body de Postman:
     *{
     *     "userName":"test",
     *     "pwd":"test"
     * }
     * @param userDTO
     * @return
     */
    @PostMapping("rest/new-user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO.getUserName(), userDTO.getPwd(), userDTO.getRole());
    }

//    @PostMapping("rest/new-user")
//    public User createUser(@RequestParam("userName") String username,
//                           @RequestParam("pwd") String pwd) {
//        return userService.createUser(username, pwd, null);
//    }

}
