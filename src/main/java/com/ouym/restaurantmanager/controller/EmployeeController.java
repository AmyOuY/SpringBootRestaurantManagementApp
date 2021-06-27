package com.ouym.restaurantmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.Employee;
import com.ouym.restaurantmanager.service.EmployeeService;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	
	@GetMapping("/newEmployee")
	public String newEmployee() {
		
		return "employee/addEmployee";
	}
	
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		
		service.addEmployee(employee);
		
		return "redirect:/employees";
	}
		
	
	@GetMapping("/employees")
	public ModelAndView getEmployees() {
		
		ModelAndView mv = new ModelAndView("employee/employees");
		
		List<Employee> employees = service.getEmployees();
		
		mv.addObject("employees", employees);
		
		return mv;
		
	}
	
	
	@GetMapping("/employee:id={id}")
	public ModelAndView getEmployee(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("employee/viewEmployee");
		
		Employee employee = service.getEmployeeById(id);
		
		mv.addObject("employee", employee);
		
		return mv;
	}
	
	
	@GetMapping("/editEmployee:id={id}")
	public ModelAndView editEmployee(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("employee/editEmployee");
		
		Employee employee = service.getEmployeeById(id);
		
		mv.addObject("employee", employee);
		
		return mv;
	}
	
	
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		
		service.updateEmployee(employee);
		
		return "redirect:/employees";
	}
	
	
	@RequestMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		service.deleteEmployee(id);
		
		return "redirect:/employees";
	}
	
}
