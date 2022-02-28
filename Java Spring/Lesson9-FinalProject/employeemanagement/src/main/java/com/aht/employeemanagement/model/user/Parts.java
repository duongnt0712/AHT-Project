package com.aht.employeemanagement.model.admin;

import javax.persistence.*;

@Entity
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parts_id")
    private int id;

    @Column(name = "parts_name",length = 50)
    private String name;

    public Parts(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
