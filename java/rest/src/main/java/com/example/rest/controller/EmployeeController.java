package com.example.rest.controller;

import com.example.rest.exception.EmployeeNotFoundException;
import com.example.rest.model.Employee;
import com.example.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

//    @RequestMapping(value = "/")
//    public String home(){
//        return "home.jsp";
//    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployee(@PathVariable int id){
        Employee emp = employeeService.getOne(id);
        if(emp == null){
            throw new EmployeeNotFoundException("id: "+id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody Employee employee){
        employeeService.add(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Employee employee){
        employeeService.update(id, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable int id){
        employeeService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
