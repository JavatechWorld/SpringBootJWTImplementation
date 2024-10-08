package com.codeWithRaman.implementation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithRaman.implementation.model.User;
import com.codeWithRaman.implementation.repository.UserRepository;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
    private UserRepository userRepository;
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load the user from the database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return a UserDetails object with the user's details
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}