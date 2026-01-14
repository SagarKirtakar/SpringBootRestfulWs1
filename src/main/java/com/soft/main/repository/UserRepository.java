package com.soft.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soft.main.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	
}
