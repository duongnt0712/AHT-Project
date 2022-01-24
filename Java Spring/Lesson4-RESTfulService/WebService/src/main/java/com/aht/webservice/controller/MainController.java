package com.aht.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aht.webservice.model.Employee;
import com.aht.webservice.model.EmployeeService;

import javax.validation.Valid;

@RestController
public class MainController {

	@Autowired
	EmployeeService empService;
	
	//GET
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllEmployees() {
		List<Employee> emps = empService.getAllEmployees();
		return new ResponseEntity<>(emps, HttpStatus.OK);
	}
	
	@RequestMapping(value="/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") String id) {
		Employee emp = empService.getEmployee(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	//POST
	@RequestMapping(value="/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee emp) {
		empService.addEmployee(emp);
		return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
	}
	
	//PUT
	@RequestMapping(value="/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp) {
		empService.updateEmployee(emp, id);
		return new ResponseEntity<>("UPDATED", HttpStatus.OK);	
	}
	
	//DELETE
	@RequestMapping(value="/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") String id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>("DELETED", HttpStatus.OK);
	}
}
