package com.aht.springbootcacheexample.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.springbootcacheexample.model.Customer;

@RestController
public class CustomerController {
	
	@RequestMapping("/customerinfo")  
	//defines a cache for method's return value  
	@Cacheable(value="customerInfo")  
	public List customerInformation() {  
	System.out.println("customer information from cache");  
	
    List detail=Arrays.asList(new Customer(5126890,"Charlie Puth","Current A/c", 450000.00),  
                              new Customer(7620015,"Andrew Flintoff","Saving A/c", 210089.00)  
                             );  
	return detail;  
	}  
}
