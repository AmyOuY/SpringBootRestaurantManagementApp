package com.ouym.restaurantmanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
}
