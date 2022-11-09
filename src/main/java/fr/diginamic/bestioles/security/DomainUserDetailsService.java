package fr.diginamic.bestioles.security;

import fr.diginamic.bestioles.entities.User;
import fr.diginamic.bestioles.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User domainUser = userRepository.findByUserName(username).orElseThrow(EntityNotFoundException::new);
        return convertUser(domainUser);
    }

    private UserDetails convertUser(User domainUser) {
        List<GrantedAuthority> authorities =
                domainUser
                        .getAuthorities()
                        .stream()
                        .map((domainAuth) -> new SimpleGrantedAuthority((domainAuth.getName())))
                        .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                domainUser.getUserName(),
                domainUser.getPasswordHash(),
                true, true, true, true,
                authorities
        );
    }
}
