package com.aht.security.controller;

import com.aht.security.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        return new ResponseEntity<>(employeeRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/employee/type")
    public ResponseEntity<Object> getByType(@Param("type") int type){
        return new ResponseEntity<>(employeeRepository.findByType(type), HttpStatus.OK);
    }

    @GetMapping("/employee/sex")
    public ResponseEntity<Object> getBySex(@Param("sex") int sex){
        return new ResponseEntity<>(employeeRepository.findBySex(sex), HttpStatus.OK);
    }
}
