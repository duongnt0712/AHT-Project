package com.aht.jdbcspring.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aht.jdbcspring.dao.StudentDAO;
import com.aht.jdbcspring.entity.Student;

public class StudentJDBCTemplate implements StudentDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {
		String SQL = "INSERT INTO student (name,age) VALUES (?,?) ";
		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Create object: " + "name: " + name + "age: " + age);
	}

	public Student getStudent(Integer id) {
		String SQL = "SELECT * FROM student WHERE id=?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new StudentMapper(), id);
		System.out.println(student.toString());
		return student;
	}

	public List<Student> listStudents() {
		String SQL = "SELECT * FROM student";
		List<Student> listStudent = jdbcTemplateObject.query(SQL, new StudentMapper());
		System.out.println("List students: ");
		for(Student student : listStudent) {
			System.out.println(student.toString());
		}
		return listStudent;
	}

	public void delete(Integer id) {
		String SQL = "DELETE FROM student WHERE id=?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Delete object with ID: " + id);	
	}

	public void update(Integer id, Integer age, String name) {
		String SQL = "UPDATE student SET age=?, name=? WHERE id=?";
		int row = jdbcTemplateObject.update(SQL, age, name, id);
		System.out.println("Update student with ID: " + id + "row: " + row);
	}
	
}
