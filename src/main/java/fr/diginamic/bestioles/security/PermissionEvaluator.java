package fr.diginamic.bestioles.security;

import fr.diginamic.bestioles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PermissionEvaluator {

    @Autowired
    UserRepository userRepository;

    public boolean isIdValid(Integer id, String username) {
        return userRepository.findByUserName(username).orElseThrow(EntityNotFoundException::new).getId() == id;
    }
}
