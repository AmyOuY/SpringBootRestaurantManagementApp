package com.ouym.restaurantmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.Message;


@RestController
public class HomeController {

	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("home/index");
		
		//mv.addObject("message", message);
		
		return mv;
	}
	
	
	@GetMapping("/alert")
	public ModelAndView alert(Message message) {
		
		ModelAndView mv = new ModelAndView("home/alert");
		
		mv.addObject("message", message);
		
		return mv;
	}
}
