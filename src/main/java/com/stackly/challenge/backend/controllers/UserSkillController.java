package com.stackly.challenge.backend.controllers;

import com.stackly.challenge.backend.auth.JwtVerifyToken;
import com.stackly.challenge.backend.entities.Skill;
import com.stackly.challenge.backend.services.SkillService;
import com.stackly.challenge.backend.services.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public class UserSkillController {

    @Autowired
    private JwtVerifyToken jwtVerifyToken;
    @Autowired
    private SkillService skillService;
    @Autowired
    private UserSkillService userSkillService;

    @PostMapping("/skills/{name}")
    public ResponseEntity<String> AddSkillToUser(@PathVariable String name, @RequestHeader String token){
        Skill skillFounded = skillService.findSkillByName(name);
        int skillId = skillFounded.getId();
        int userId = jwtVerifyToken.verifyToken(token);

        return new ResponseEntity<>(userSkillService.AddSkillToUser(skillId, userId), HttpStatus.OK);

    }
}
