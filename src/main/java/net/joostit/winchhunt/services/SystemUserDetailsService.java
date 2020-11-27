package net.joostit.winchhunt.services;

import net.joostit.winchhunt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository UserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return UserRepository.findByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException("User " + s + " was not found")
        );
    }
}
