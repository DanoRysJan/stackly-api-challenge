package com.stackly.challenge.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "skill", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "uk_name")})
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
    @JoinColumn(name ="fk_skill_user",referencedColumnName = "skill_id")
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String skillname) {
        this.name = skillname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date created_at) {
        this.createdAt = created_at;
    }
}
