package com.stackly.challenge.backend.controllers;

import com.stackly.challenge.backend.auth.JwtVerifyToken;
import com.stackly.challenge.backend.entities.Skill;
import com.stackly.challenge.backend.entities.User;
import com.stackly.challenge.backend.services.SkillService;
import com.stackly.challenge.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private JwtVerifyToken jwtVerifyToken;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

}
