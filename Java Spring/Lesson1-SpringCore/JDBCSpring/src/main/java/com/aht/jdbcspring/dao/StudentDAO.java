package com.aht.jdbcspring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.aht.jdbcspring.entity.Student;

public interface StudentDAO {
	//Initialize connect
	public void setDataSource(DataSource dataSource);
	
	//CRUD
	public void create(String name, Integer age);
	
	public Student getStudent(Integer id);
	
	public List<Student> listStudents();
	
	public void delete(Integer id);
	
	public void update(Integer id, Integer age, String name);
	
}
