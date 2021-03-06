package com.carrey.auth.web.service;

import java.util.HashSet;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.carrey.auth.web.model.Role;
import com.carrey.auth.web.model.User;
import com.carrey.auth.web.repository.UserRepository;

 
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
 
        return new org.springframework.security.core.userdetails.User(user.getUsername(), 
                                                                      user.getPassword(),
                                                                      grantedAuthorities);
    }
}
