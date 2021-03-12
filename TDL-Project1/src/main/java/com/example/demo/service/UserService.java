package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.User;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.mapper.UserMapper;


@Service
public class UserService {

	private UserRepository userRepository;
	private UserMapper userMapper;
	
	@Transactional
	public List<UserDTO> readAllUsers() {
		List<User> usersInDb = userRepository.findAll();
		List<UserDTO> returnables = new ArrayList<UserDTO>();
		
		usersInDb.forEach(user -> {
			returnables.add(userMapper.mapToDTO(user));
		});
		
		return returnables;
	}
	
	public UserDTO readById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return userMapper.mapToDTO(user.get());
		} else {
			throw new UserNotFoundException("User not found");
		}
	}
	
	public UserDTO createUser(User user) {
		User savedUser = userRepository.save(user);
		
		return userMapper.mapToDTO(savedUser);
	}
	public Boolean deleteUser(Integer id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
		
		boolean doesItExistStill = userRepository.existsById(id);
		return !doesItExistStill;
	}
}

