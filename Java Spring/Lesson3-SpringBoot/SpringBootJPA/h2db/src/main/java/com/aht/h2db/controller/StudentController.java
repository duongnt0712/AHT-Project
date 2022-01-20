package com.aht.h2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aht.h2db.model.Student;
import com.aht.h2db.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	//Object[] obj
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/student")
	public int saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student.getId();
	}
	
	@DeleteMapping("/student/{id}")  
	private void deleteStudent(@PathVariable("id") int id) {  
		studentService.deleteStudent(id);  
	}  
}
