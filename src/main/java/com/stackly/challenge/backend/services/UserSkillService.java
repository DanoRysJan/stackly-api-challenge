package com.stackly.challenge.backend.services;

import com.stackly.challenge.backend.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {

    @Autowired
    private UserSkillRepository userSkillRepository;

    public String AddSkillToUser(int skillId, int employeeId){
        userSkillRepository.AddSkillToUser(employeeId, skillId);
        return "La habilidad se agrego correctamente";
    }

}
