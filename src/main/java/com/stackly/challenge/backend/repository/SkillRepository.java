package com.stackly.challenge.backend.repository;

import com.stackly.challenge.backend.entities.Skill;
import org.springframework.data.repository.CrudRepository;

public interface SkillRepository  extends CrudRepository<Skill, Integer> {
    Skill findByName(String name);
}

