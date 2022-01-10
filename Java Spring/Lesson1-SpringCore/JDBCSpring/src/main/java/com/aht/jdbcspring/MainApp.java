package com.aht.jdbcspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aht.jdbcspring.database.StudentJDBCTemplate;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		// Create new records
//		studentJDBCTemplate.create("Dai", 10);
//		studentJDBCTemplate.create("Giang", 2);
		
		// List 1 record
		studentJDBCTemplate.getStudent(2); 	
		
		// List all record
		studentJDBCTemplate.listStudents();
		
		// Update record 
		studentJDBCTemplate.update(2, 2, "Giang");
		
		studentJDBCTemplate.getStudent(2); 	
	}
}
