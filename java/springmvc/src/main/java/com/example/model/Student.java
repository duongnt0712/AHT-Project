package com.example.model;

import org.hibernate.validator.constraints.*;

import jakarta.validation.constraints.NotEmpty;

public class Student {
	@Range(min = 0, max = 18)
	   private Integer age;
	@NotEmpty
	   private String name;
	   private Integer id;

	   public void setAge(Integer age) {
	      this.age = age;
	   }
	   public Integer getAge() {
	      return age;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }

	   public void setId(Integer id) {
	      this.id = id;
	   }
	   public Integer getId() {
	      return id;
	   }
	}
