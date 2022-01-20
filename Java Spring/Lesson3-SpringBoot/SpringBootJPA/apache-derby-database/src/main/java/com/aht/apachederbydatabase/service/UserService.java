package com.aht.apachederbydatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.apachederbydatabase.model.UserRecord;
import com.aht.apachederbydatabase.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserRecord>getAllUsers() {
		List<UserRecord> allUsers = new ArrayList<>();
		userRepository.findAll().forEach(allUsers::add);
		return allUsers;
	}
	
	public void addUser(UserRecord userRecord) {
		userRepository.save(userRecord);
	}
}
