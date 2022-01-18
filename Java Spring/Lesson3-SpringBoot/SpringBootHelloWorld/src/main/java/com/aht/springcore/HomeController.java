package com.aht.springcore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class HomeController {  

    @RequestMapping("/hello")  //routing information
    public String hello(){  
        return"Hello!!!!!!!!";  
    }  

}   