package com.aht.h2db.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.h2db.model.Student;
import com.aht.h2db.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		List<Student> allStudents = new ArrayList<>();
		studentRepository.findAll().forEach(allStudents::add);
		return allStudents;
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
}
