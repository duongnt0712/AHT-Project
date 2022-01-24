package com.aht.webservice.model;

import javax.validation.constraints.Size;
import java.util.Date;

public class Employee {
	
	private String id;

	@Size(min=5)
	private String name;

	public Employee() {

	}

	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
