package com.aht.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class SpringBootJdbcController {  
	
    @Autowired  
    JdbcTemplate jdbc;    
    
    @RequestMapping("/insert")  
    public String index(){  
        jdbc.execute("insert into student(name,age)values('dai',10)");  
        return"data inserted Successfully";  
    }  
}  