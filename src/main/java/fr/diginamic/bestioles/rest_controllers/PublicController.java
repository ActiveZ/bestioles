package fr.diginamic.bestioles.rest_controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @GetMapping("rest/public")
    public String pub() {
        return "Hello public !";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("rest/public/admin")
    public String adminProtected() {
        return "Hello protected admin !";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("rest/public/admin-user")
    public String accountAuthenticated() {
        return "Hello, your account is authenticated as admin or user !";
    }

    @PreAuthorize("principal.enabled == true")
    @GetMapping("rest/public/enabled")
    public String accountEnabled() {
        return "Hello, your account is enabled !";
    }

    /**
     * Authorise l'accès si l'id est celui accepté par service permission evaluator (id:1)
     * @param id
     * @return
     */
    @PreAuthorize("@permissionEvaluator.isIdValid(#id, principal.getUsername())")
    @GetMapping("rest/public/id")
    public String authorizeById(@RequestParam Integer id) {
        return "hello, you have id 1 !";
    }
}
