package com.example.rest.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

    @NotNull(message = "Id cannot be null")
    private int id;

    @Size(min = 10, max = 40, message = "Full Name must contains 10-40 characters")
    private String fullName;

    @Max(value = 50)
    private int age;

    private String type;

    public Employee(int id, String fullName, int age, String type) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
