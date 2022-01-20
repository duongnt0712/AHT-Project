package com.aht.webservice.controller;

import com.aht.webservice.model.Employee;
import com.aht.webservice.model.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    EmployeeService empService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllEmployees() {
        List<Employee> employees = empService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getEmployee(@PathVariable("id") String id) {
        Employee emp = empService.getEmployee(id);
        return new ResponseEntity<Object>(emp, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Object> addEmployee(@RequestBody Employee emp) {
        empService.addEmployee(emp);
        return new ResponseEntity<Object>("CREATED", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp) {
        empService.updateEmployee(emp, id);
        return new ResponseEntity<Object>("UPDATED", HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String id) {
        empService.deleteEmployee(id);
        return new ResponseEntity<Object>("DELETED", HttpStatus.OK);
    }

}
