package fr.diginamic.bestioles.services;

import fr.diginamic.bestioles.entities.User;
import fr.diginamic.bestioles.repositories.AuthorityRepository;
import fr.diginamic.bestioles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(String userName, String pwd, String Role) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPasswordHash(passwordEncoder.encode(pwd));
        newUser.getAuthorities().add(authorityRepository.findById("ROLE_USER").orElseThrow(EntityNotFoundException::new));
        return userRepository.save(newUser);
    }
}
