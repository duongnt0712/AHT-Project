package com.example.rest.controller;

import com.example.rest.model.Employee;
import com.example.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getOne(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String create(@RequestBody Employee employee){
        return employeeService.add(employee)?"Created":"Failed";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.update(id, employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        return employeeService.remove(id)?"Deleted!":"Failed!";
    }
}
