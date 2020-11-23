package com.stackly.challenge.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_skill", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","skill_id"}, name = "uk_user_skill")})
public class UserSkill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Column(name = "skill_id", nullable = false)
    private int skillId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_skill_user")
    private Skill skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_user_skill")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
