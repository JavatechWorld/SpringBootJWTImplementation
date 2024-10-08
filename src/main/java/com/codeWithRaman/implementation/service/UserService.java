package com.codeWithRaman.implementation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeWithRaman.implementation.model.User;
import com.codeWithRaman.implementation.repository.UserRepository;


@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	@Autowired
    private  PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("ROLE_USER"); // Set a default role
        userRepository.save(user);
    }
}