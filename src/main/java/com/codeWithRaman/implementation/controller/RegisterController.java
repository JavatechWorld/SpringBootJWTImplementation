package com.codeWithRaman.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codeWithRaman.implementation.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class RegisterController {
	@Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return ResponseEntity.ok("User registered successfully");
    }
}

