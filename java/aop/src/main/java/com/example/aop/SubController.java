package com.example.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubController {

    /*

     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String get(){
        return "abc";
    }
}
