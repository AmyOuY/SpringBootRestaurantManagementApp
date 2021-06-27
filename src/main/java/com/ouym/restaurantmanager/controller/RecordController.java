package com.ouym.restaurantmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.DiningTable;
import com.ouym.restaurantmanager.model.DisplayOrder;
import com.ouym.restaurantmanager.model.DisplayOrderDetail;
import com.ouym.restaurantmanager.model.Employee;
import com.ouym.restaurantmanager.model.Food;
import com.ouym.restaurantmanager.model.Order;
import com.ouym.restaurantmanager.model.OrderDetail;
import com.ouym.restaurantmanager.service.DiningTableService;
import com.ouym.restaurantmanager.service.EmployeeService;
import com.ouym.restaurantmanager.service.FoodService;
import com.ouym.restaurantmanager.service.OrderService;


@Controller
public class RecordController {

	@Autowired
	private OrderService orderService;
		
	@Autowired
	private DiningTableService diningTableService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FoodService foodService;
	
	
	@GetMapping("/allOrderDetails")
	public ModelAndView allOrderDetails() {
		
		List<OrderDetail> orderDetails = orderService.getOrderDetails();
		
		List<DisplayOrderDetail> displayOrderDetails = new ArrayList<>();
		
		for (OrderDetail orderDetail : orderDetails) {
			
			DiningTable diningTable = diningTableService.getDiningTableById(orderDetail.getDiningTableId());
			Employee attendant = employeeService.getEmployeeById(orderDetail.getAttendantId());
			Food food = foodService.getFoodById(orderDetail.getFoodId());
			
			displayOrderDetails.add(new DisplayOrderDetail(
					orderDetail.getId(),
					diningTable.getTableNumber(),
					attendant.getFirstName() + " " + attendant.getLastName(),
					food.getFoodName(),
					food.getPrice(),
					orderDetail.getQuantity(),
					orderDetail.getCreatedDate(),
					orderDetail.getOrderId()
					)
				);
		}
		
		ModelAndView mv = new ModelAndView("/record/allOrderDetails");
		mv.addObject("displayOrderDetails", displayOrderDetails);
		
		return mv;
		
	}
	
	
	
	@GetMapping("/allOrders")
	public ModelAndView allOrders() {
		
		List<Order> orders = orderService.getOrders();
		
		List<DisplayOrder> displayOrders = new ArrayList<>();
		
		for (Order order : orders) {
			
			DiningTable diningTable = diningTableService.getDiningTableById(order.getDiningTableId());
			Employee attendant = employeeService.getEmployeeById(order.getAttendantId());
			
			displayOrders.add(new DisplayOrder(
					order.getId(),
					diningTable.getTableNumber(),
					attendant.getFirstName() + " " + attendant.getLastName(),
					order.getSubTotal(),
					order.getTax(),
					order.getTotal(),
					order.getCreatedDate(),
					order.isBillPaid()
					)
				);
			
			System.out.println(order.isBillPaid());
			
		}
		
		ModelAndView mv = new ModelAndView("/record/allOrders");
		mv.addObject("displayOrders", displayOrders);
		
		return mv;
		
	}
}
