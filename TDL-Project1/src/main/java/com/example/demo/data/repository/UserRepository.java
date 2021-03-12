package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.data.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM user", nativeQuery = true)
	public List<User> getAllUsers();
	
	@Query("SELECT * FROM user WHERE name = ?1")
	public User getUserByName(String name);
	
	@Query("SELECT * FROM user WHERE user_id = ?1")
	public User getUserById(int userid);
	
}
