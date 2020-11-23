package com.stackly.challenge.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to my API!! by Dano";
    }
}
