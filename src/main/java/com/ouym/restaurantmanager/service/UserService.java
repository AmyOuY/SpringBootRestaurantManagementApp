package com.ouym.restaurantmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.User;
import com.ouym.restaurantmanager.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	
	public User addUser(User user) {
		
		return repo.save(user);
	}
	
	
	public List<User> getUsers(){
		
		List<User> users = repo.findAll();
		
		users.sort((a, b) -> a.getUsername().compareTo(b.getUsername()));
		
		return users;
	}
	
	
	
	public User getUser(int id) {
		
		return repo.findById(id).orElse(null);
	}
	
	
	
	public User updateUser(User user) {
		
		return repo.save(user);
	}
	
	
	public String deleteUser(int id) {
		
		repo.deleteById(id);
		
		return "Successfully delete user: " + id; 
	}
}
