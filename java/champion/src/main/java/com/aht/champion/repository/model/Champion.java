package com.aht.champion.repository.model;

import com.aht.champion.utils.Difficulty;
import com.aht.champion.utils.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "champion")
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "lmth")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name ="title", nullable = false)
    private String title;

    @Column(name ="role", nullable = false)
    private Role role;

    @Column(name ="difficulty", nullable = false)
    private Difficulty difficulty;

    @Column(name ="lore", nullable = false, length = 999999)
    private String lore;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "champion")
    @Column(name ="skins", nullable = false)
    private List<Skin> skins;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "champion")
    @Column(name ="skills", nullable = false)
    private List<Skill> skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public List<Skin> getSkins() {
        return skins;
    }

    public void setSkins(List<Skin> skins) {
        this.skins = skins;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", role=" + role +
                ", difficulty=" + difficulty +
                ", lore='" + lore + '\'' +
                ", skins=" + skins +
                ", skills=" + skills +
                '}';
    }
}
