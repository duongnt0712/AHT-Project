package com.aht.jdbcspring.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.aht.jdbcspring.entity.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setAge(rs.getInt("age"));
		student.setName(rs.getString("name"));
		
		return student;
	}

}	
