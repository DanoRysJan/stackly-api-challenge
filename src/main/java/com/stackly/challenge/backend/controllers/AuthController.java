package com.stackly.challenge.backend.controllers;

import com.stackly.challenge.backend.dto.UserDto;
import com.stackly.challenge.backend.entities.User;
import com.stackly.challenge.backend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> SignUp(@RequestBody User user){
        return new ResponseEntity<>( authService.SignUp(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> SignIn(@RequestBody UserDto user){
        return new ResponseEntity<>(authService.SignInUser(user), HttpStatus.FOUND);
    }

}
