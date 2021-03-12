package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.model.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> data = userService.readAllUsers();
		
		return new ResponseEntity<List<UserDTO>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("user_id") Integer userid) {
		UserDTO user = userService.readById(userid);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody User user) {
		UserDTO newUser = userService.createUser(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newUser.getUserid()));
	
		return new ResponseEntity<UserDTO>(newUser, headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDTO> getUserById1(@PathVariable("userid") Integer userid) {
		UserDTO user = userService.readById(userid);
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("userid") int userid) {		
		return new ResponseEntity<Boolean>(userService.deleteUser(userid), HttpStatus.OK);
	}

}
