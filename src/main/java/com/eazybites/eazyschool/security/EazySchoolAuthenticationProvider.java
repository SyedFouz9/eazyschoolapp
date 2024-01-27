package com.eazybites.eazyschool.security;

import com.eazybites.eazyschool.model.Person;
import com.eazybites.eazyschool.model.Roles;
import com.eazybites.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EazySchoolAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String pass = authentication.getCredentials().toString();
        Person person = personRepository.findByName(name);
        if (null != person && person.getPersonId() > 0 && passwordEncoder.matches(pass, person.getPwd())) {
            return new UsernamePasswordAuthenticationToken(person.getName(), pass, getGrantedAuthorities(person.getRole()));
        } else throw new BadCredentialsException("Invalid Credentials");
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(Roles role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
