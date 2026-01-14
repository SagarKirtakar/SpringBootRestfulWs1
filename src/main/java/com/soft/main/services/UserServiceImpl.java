package com.soft.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.main.entities.User;

import com.soft.main.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public User updateUserDetails(int id, User user) {
		User userData = userRepository.findById(id).orElse(null);
		
		if(userData != null) {
			return userRepository.save(user);
		}else {
			throw new RuntimeException("User not found: "+id);
		}
		
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public boolean existsById(int id) {
		return userRepository.existsById(id);
	}

	

}
