package com.ouym.restaurantmanager.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.Message;


@Controller
public class HomeController {

	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("home/index");
		
		return mv;
	}
	
	
	@GetMapping("/alert")
	public ModelAndView alert(Message message) {
		
		ModelAndView mv = new ModelAndView("home/alert");
		
		mv.addObject("message", message);
		
		return mv;
	}
	
	
	@GetMapping("/login")
	public String login() {
		
		return "home/login";
	}
	
	
	@GetMapping("/accessdenied")
	public String accessdenied() {
		
		return "home/accessdenied";
	}
	
}
