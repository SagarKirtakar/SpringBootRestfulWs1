package com.soft.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soft.main.entities.User;
import com.soft.main.services.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {		
		return userServiceImpl.createUser(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser() {
		return userServiceImpl.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = userServiceImpl.getUserById(id).orElse(null);
		
		if(user != null) {
			return ResponseEntity.ok().body(user);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id, @RequestBody User user) {
		User validUser = userServiceImpl.updateUserDetails(id, user);
		if(validUser != null) {
			return ResponseEntity.ok(validUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		if(!userServiceImpl.existsById(id)) {
			return ResponseEntity.ok().body("User not found due not some error..?");
		}else {
			return ResponseEntity.ok().body("User deleted successfully...!");
		}
	
	}
	
}
