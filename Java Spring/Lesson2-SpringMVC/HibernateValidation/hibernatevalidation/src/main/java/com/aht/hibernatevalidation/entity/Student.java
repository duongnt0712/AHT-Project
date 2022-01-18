package com.aht.hibernatevalidation.entity;

import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotEmpty;

public class Student {
	
	private Integer id;
	
	@Range(min=1, max=100)
	private Integer age;
	
	@NotEmpty
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
	
}
