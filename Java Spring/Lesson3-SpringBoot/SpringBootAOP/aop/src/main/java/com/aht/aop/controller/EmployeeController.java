package com.aht.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aht.aop.model.Employee;
import com.aht.aop.service.EmployeeService;

/**
 * @author Admin
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/add/employee")
	public Employee createEmployee(@RequestParam("empId") String empId, @RequestParam("fname") String fname, @RequestParam("sname") String sname) {
		return employeeService.createEmployee(empId, fname, sname);
	}
	
	@RequestMapping("/display/employee")
	public Employee displayEmployee(@RequestParam("empId") String empId) {
		return employeeService.displayEmployee(empId);
	}
}
