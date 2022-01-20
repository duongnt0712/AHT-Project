package com.aht.apachederbydatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.apachederbydatabase.model.UserRecord;
import com.aht.apachederbydatabase.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public List<UserRecord> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/add-user")
	public void addUser(@RequestBody UserRecord userRecord) {
		userService.addUser(userRecord);
	}
}
