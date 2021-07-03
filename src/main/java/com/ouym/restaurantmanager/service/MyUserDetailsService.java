package com.ouym.restaurantmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.MyUserDetails;
import com.ouym.restaurantmanager.model.User;
import com.ouym.restaurantmanager.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUsername(username);
		
		if (user == null) new UsernameNotFoundException("Error! " + username + " Not found!");
		
		return new MyUserDetails(user);
		
	}

	

}
