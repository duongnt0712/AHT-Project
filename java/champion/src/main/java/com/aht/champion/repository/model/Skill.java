package com.aht.champion.repository.model;

import com.aht.champion.utils.Slot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slot", nullable = false)
    private Slot slot;

    @Column(name = "description", nullable = false, length = 999999)
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "champion_id")
    private Champion champion;

    @JsonIgnore
    @Transient
    private Long champion_idi;

    public Long getChampion_idi() {
        return champion_idi;
    }

    public void setChampion_idi(Long champion_id) {
        this.champion_idi = champion_id;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", slot=" + slot +
                ", description='" + description + '\'' +
                '}';
    }
}
