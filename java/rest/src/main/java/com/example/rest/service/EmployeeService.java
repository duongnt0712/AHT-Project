package com.example.rest.service;

import com.example.rest.exception.EmployeeNotFoundException;
import com.example.rest.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();

    public List<Employee> getAll(){
        return employees;
    }

    public Employee getOne(int id){
        return getById(id);
    }

    public void add(Employee employee){
        employees.add(employee);
    }

    public void remove(int id){
        if(getById(id)==null){
            throw new EmployeeNotFoundException("id: "+id);
        }
        employees.remove(getById(id));
    }

    public void update(int id, Employee employee){
        if(getById(id)==null){
            throw new EmployeeNotFoundException("id: "+id);
        }
        employees.set(employees.indexOf(getById(id)), employee);

    }

    private Employee getById(int id){
        Employee employee = null;
        for (Employee value : employees) {
            if (value.getId() == id) {
                employee = value;
            }
        }
        return employee;
    }
}
