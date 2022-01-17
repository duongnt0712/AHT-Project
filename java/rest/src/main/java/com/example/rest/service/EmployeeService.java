package com.example.rest.service;

import com.example.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();

    public List<Employee> getAll(){
        return employees;
    }

    public Employee getOne(int id){
        return getById(id);
    }

    public boolean add(Employee employee){
        return employees.add(employee);
    }

    public boolean remove(int id){
        if(getById(id)!=null){
            employees.remove(getById(id));
            return true;
        }
        return false;
    }

    public Employee update(int id, Employee employee){
        if(getById(id)==null){
            return null;
        }else {
            return employees.set(employees.indexOf(getById(id)), employee);
        }
    }

    private Employee getById(int id){
        Employee employee = null;
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId() == id){
                employee = employees.get(i);
            }
        }
        return employee;
    }
}
