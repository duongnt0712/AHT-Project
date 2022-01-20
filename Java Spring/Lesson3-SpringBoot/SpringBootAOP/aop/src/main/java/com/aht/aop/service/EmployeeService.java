package com.aht.aop.service;

import com.aht.aop.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(String empId, String firstName, String secondName);
	
	public Employee displayEmployee(String empId);
	
}
