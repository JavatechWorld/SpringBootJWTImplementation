package com.codeWithRaman.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.codeWithRaman.implementation.config.JwtUtils;
import com.codeWithRaman.implementation.service.CustomUserDetailsService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    private CustomUserDetailsService customUserDetailsService;
	@Autowired
    private  JwtUtils jwtUtils;
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        return jwtUtils.generateToken(userDetails.getUsername());
    }
}

