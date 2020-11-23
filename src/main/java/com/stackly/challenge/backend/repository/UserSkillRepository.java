package com.stackly.challenge.backend.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserSkillRepository extends CrudRepository<UserSkillRepository,Integer> {
    @Modifying
    @Query(value = "insert into user_skill (user_id, skill_id) values (:userId, :skillId)", nativeQuery = true)
    void AddSkillToUser(@Param(value = "userId") int userId , @Param(value = "skillId") int skillId);

}
