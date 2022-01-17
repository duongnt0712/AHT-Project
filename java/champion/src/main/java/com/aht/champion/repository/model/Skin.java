package com.aht.champion.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "skin")
public class Skin {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "chromas")
    private boolean chromas;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChromas() {
        return chromas;
    }

    public void setChromas(boolean chromas) {
        this.chromas = chromas;
    }

    @Override
    public String toString() {
        return "Skin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chromas=" + chromas +
                ", champion=" + champion +
                '}';
    }
}
