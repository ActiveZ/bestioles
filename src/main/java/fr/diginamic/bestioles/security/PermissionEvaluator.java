package fr.diginamic.bestioles.security;

import org.springframework.stereotype.Service;

@Service
public class PermissionEvaluator {
    public boolean isIdValid(Integer id) {
        return id == 1;
    }
}
