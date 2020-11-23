package com.stackly.challenge.backend.services;

import com.stackly.challenge.backend.entities.Skill;
import com.stackly.challenge.backend.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public Skill createSkill(Skill skill){
        skillRepository.save(skill);
        return skill;
    }

    public Skill findSkillByName(String name){
        return skillRepository.findByName(name);
    }
}
