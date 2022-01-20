package com.aht.aop.service;

import org.springframework.stereotype.Service;

import com.aht.aop.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public Employee createEmployee(String empId, String firstName, String secondName) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setFirstName(firstName);
		emp.setSecondName(secondName);		
		System.out.println("Employee with: empId = " + empId + ", fname = " + firstName + ", sname = " + secondName);
		return emp;
	}
	
	public Employee displayEmployee(String empId) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		System.out.println("Employee[empId = " + empId + "]");
		return emp;
	}

}
