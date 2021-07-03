package com.ouym.restaurantmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.User;
import com.ouym.restaurantmanager.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	
	@GetMapping("/newUser")
	public String newUser() {
		
		return "user/addUser";
	}
	
	
	@RequestMapping("/addUser")
	public String addUser(User user) {

		service.addUser(user);
		
		return "redirect:/users";
	}
	
	
	@GetMapping("/users")
	public ModelAndView getUsers() {
		
		ModelAndView mv = new ModelAndView("user/users");
		
		List<User> users = service.getUsers();
		
		mv.addObject("users", users);
		
		return mv;
	}
	
	
	@GetMapping("/user:id={id}")
	public ModelAndView getUser(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("user/editUser");
		
		User user = service.getUser(id);
		
		mv.addObject("user", user);
		
		return mv;
	}
	
	
	@GetMapping("/editUser:id={id}")
	public ModelAndView editUser(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("user/editUser");
		
		User user = service.getUser(id);
		
		mv.addObject("user", user);
		
		return mv;
	}
	
	
	@RequestMapping("/updateUser")
	public String updateUser(User user) {
		
		service.updateUser(user);
		
		return "redirect:/users";
	}
	
	
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		
		service.deleteUser(id);
		
		return "redirect:/users";
	}
}
