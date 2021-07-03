package com.ouym.restaurantmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.DiningTable;
import com.ouym.restaurantmanager.model.DisplayOrder;
import com.ouym.restaurantmanager.model.DisplayOrderDetail;
import com.ouym.restaurantmanager.model.Employee;
import com.ouym.restaurantmanager.model.FillInOrderDetail;
import com.ouym.restaurantmanager.model.Food;
import com.ouym.restaurantmanager.model.FoodType;
import com.ouym.restaurantmanager.model.Message;
import com.ouym.restaurantmanager.model.Order;
import com.ouym.restaurantmanager.model.OrderDetail;
import com.ouym.restaurantmanager.service.DiningTableService;
import com.ouym.restaurantmanager.service.EmployeeService;
import com.ouym.restaurantmanager.service.FoodService;
import com.ouym.restaurantmanager.service.OrderService;



@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
		
	@Autowired
	private DiningTableService diningTableService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FoodService foodService;
	
	
	
	
	@GetMapping("/getDropdowns")
	public ModelAndView getDropdowns() {
		
		List<DiningTable> diningTables = diningTableService.getDiningTables();
		List<Employee> employees = employeeService.getEmployees();
		List<FoodType> foodTypes = foodService.getFoodTypes();
		
		ModelAndView mv = new ModelAndView("order/getDropdowns");
				
		mv.addObject("diningTables", diningTables);
		mv.addObject("employees", employees);
		mv.addObject("foodTypes", foodTypes);
		
		return mv;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/getFoodsByTypeId/{typeId}")
	public List<Food> getFoodsByTypeId(@PathVariable int typeId){
		
		List<Food> foods = foodService.getFoodByTypeId(typeId);
		
		return foods;
		
	}
	
	
	@ResponseBody
	@RequestMapping("/getFoodById/{id}")
	public Food getFoodById(@PathVariable int id) {
		
		return foodService.getFoodById(id);
	}
	
		
	
	@RequestMapping("/addOrderDetail")
	public ModelAndView addOrderDetail(
			@RequestParam("diningTable") int diningTable, 
			@RequestParam("employee") String employee,
			@RequestParam("foodType") int foodType, 
			@RequestParam("foodName") int foodName, 
			@RequestParam("price") double price, 
			@RequestParam("quantity") int quantity) {
		
		DiningTable table = diningTableService.getDiningTableByTableNumber(diningTable);
		
		FillInOrderDetail fillInOrderDetail = new FillInOrderDetail(
				table.getId(),
				employee,
				foodType,
				foodName,
				price,
				quantity
				);
		
		orderService.addOrderDetail(fillInOrderDetail);
		
		return orderDetailsByTable(diningTable);
		
	}
			
	
	
	@GetMapping("/orderDetailsByTable")
	@ResponseBody
	public ModelAndView orderDetailsByTable(@RequestParam int tableNumber) {
		
		ModelAndView mv = new ModelAndView();
		
		if (diningTableService.validDiningTable(tableNumber) == false) {
			Message message = new Message("Dining Table " + tableNumber + " does not exist!");
			mv.setViewName("home/alert");
			mv.addObject("message", message);			
			return mv;
		}
		
		DiningTable diningTable = diningTableService.getDiningTableByTableNumber(tableNumber);
				
		List<OrderDetail> orderDetails = orderService.getUnpaidOrderDetailsByDiningTableId(diningTable.getId());
		
		if (orderDetails.size() == 0) {
			Message message = new Message("Error! There is no currently active order for Table " + tableNumber);
			mv.setViewName("home/alert");
			mv.addObject("message", message);			
			return mv;
		}
		
		List<DisplayOrderDetail> displayOrderDetails = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			
			Food food = foodService.getFoodById(orderDetail.getFoodId());			
			
			Employee attendant = employeeService.getEmployeeById(orderDetail.getAttendantId());
			
			displayOrderDetails.add(
					new DisplayOrderDetail(
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
				
		mv.setViewName("order/orderDetailsByTable");
		mv.addObject("displayOrderDetails", displayOrderDetails);
		
		return mv;
	}
	
	
	@RequestMapping("/searchOrderByTable")
	public String searchOrderByTable() {
		
		return "order/searchOrderByTable";
		
	}
	
	
	
	@GetMapping("/orderDetails")
	public List<OrderDetail> getOrderDetails(){
		
		return orderService.getOrderDetails();
	}
	
	
	@GetMapping("/orderDetail:id={id}")
	public ModelAndView getOrderDetail(@PathVariable int id) {
				
		OrderDetail orderDetail = orderService.getOrderDetailById(id);
		DiningTable diningTable = diningTableService.getDiningTableById(orderDetail.getDiningTableId());
		Employee attendant = employeeService.getEmployeeById(orderDetail.getAttendantId());
		Food food = foodService.getFoodById(orderDetail.getFoodId());
		
		DisplayOrderDetail displayOrderDetail = new DisplayOrderDetail(
				orderDetail.getId(),
				diningTable.getTableNumber(),
				attendant.getFirstName() + " " + attendant.getLastName(),
				food.getFoodName(),
				food.getPrice(),
				orderDetail.getQuantity(),
				orderDetail.getCreatedDate(),
				orderDetail.getOrderId()
				);
		
		ModelAndView mv = new ModelAndView("order/orderDetail");
		mv.addObject("displayOrderDetail", displayOrderDetail);
		
		return mv;
	}
	
	
	@GetMapping("/editOrderDetail:id={id}")
	public ModelAndView editOrderDetail(@PathVariable int id) {
		
		OrderDetail orderDetail = orderService.getOrderDetailById(id);
		DiningTable diningTable = diningTableService.getDiningTableById(orderDetail.getDiningTableId());
		Employee attendant = employeeService.getEmployeeById(orderDetail.getAttendantId());
		Food food = foodService.getFoodById(orderDetail.getFoodId());
		
		DisplayOrderDetail displayOrderDetail = new DisplayOrderDetail(
				orderDetail.getId(),
				diningTable.getTableNumber(),
				attendant.getFirstName() + " " + attendant.getLastName(),
				food.getFoodName(),
				food.getPrice(),
				orderDetail.getQuantity(),
				orderDetail.getCreatedDate(),
				orderDetail.getOrderId()
				);
		
		ModelAndView mv = new ModelAndView("order/editOrderDetail");
		mv.addObject("displayOrderDetail", displayOrderDetail);
		
		return mv;
	}
	
	
	@RequestMapping("/updateOrderDetail")
	public String updateOrderDetail(DisplayOrderDetail displayOrderDetail) {
		
		DiningTable diningTable = diningTableService.getDiningTableByTableNumber(displayOrderDetail.getDiningTableNumber());
		String[] attendantName = displayOrderDetail.getAttendant().split(" ");
		Employee attendant = employeeService.getEmployeeByName(attendantName[0], attendantName[1]);
		Food food = foodService.getFoodByFoodName(displayOrderDetail.getFoodName());
		
		OrderDetail orderDetail = new OrderDetail();		
		orderDetail.setId(displayOrderDetail.getId());
		orderDetail.setDiningTableId(diningTable.getId());
		orderDetail.setAttendantId(attendant.getId());
		orderDetail.setFoodId(food.getId());
		orderDetail.setQuantity(displayOrderDetail.getQuantity());
		orderDetail.setOrderId(displayOrderDetail.getOrderId());
		
		orderService.updateOrderDetail(orderDetail);
		
		return "redirect:/orderDetailsByTable?tableNumber=" + diningTable.getTableNumber();
	}
	
	

	@RequestMapping("/deleteOrderDetail/{id}")
	public String deleteOrderDetail(@PathVariable int id) {
		
		OrderDetail orderDetail = orderService.getOrderDetailById(id);
		DiningTable diningTable = diningTableService.getDiningTableById(orderDetail.getDiningTableId());
		
		orderService.deleteOrderDetail(id);
		
		return "redirect:/orderDetailsByTable?tableNumber=" + diningTable.getTableNumber();
	}
			
	
	
	@RequestMapping("/addOrderByTable")
	public String addOrderByTable(@RequestParam int tableNumber) {
		
		if (diningTableService.validDiningTable(tableNumber) == false) {
			return "Table Number doesn't exist";
		}
		
		DiningTable diningTable = diningTableService.getDiningTableByTableNumber(tableNumber);
		
		List<Order> orders = orderService.getUnpaidOrders(false);
		
		for (Order order : orders) {
			
			if (order.getDiningTableId() == diningTable.getId()) {
				
				orderService.deleteOrder(order.getId());
				
				break;
			}
		}
		
		orderService.addOrderByTableId(diningTable.getId());
		
		return "redirect:/unpaidOrders";
		
	}
	
	
	
	@PostMapping("/addOrderByTableId/{diningTableId}")
	public Order addOrderByTableId(@PathVariable int diningTableId) {
		
		return orderService.addOrderByTableId(diningTableId);
	}
		
	
	
	@GetMapping("/unpaidOrders")
	public ModelAndView getUnpaidOrders(){
		
		List<Order> orders = orderService.getUnpaidOrders(false);
		List<DisplayOrder> displayOrders = new ArrayList<>();
		
		for (Order order : orders) {
			DiningTable diningTable = diningTableService.getDiningTableById(order.getDiningTableId());
			
			Employee attendant = employeeService.getEmployeeById(order.getAttendantId());
			
			DisplayOrder displayOrder = new DisplayOrder(
					order.getId(),
					diningTable.getTableNumber(),
					attendant.getFirstName() + " " + attendant.getLastName(),
					order.getSubTotal(),
					order.getTax(),
					order.getTotal(),					
					order.getCreatedDate(),
					order.isBillPaid()
					);
			
			displayOrders.add(displayOrder);
		}
		
		
		ModelAndView mv = new ModelAndView("order/orders");
		mv.addObject("displayOrders", displayOrders);
		
		return mv;
	}
	
	
	
	@GetMapping("/order:id={id}")
	public ModelAndView getOrderDetailsByOrderId(@PathVariable int id) {
		
		Order order = orderService.getOrder(id);
		
		DiningTable diningTable = diningTableService.getDiningTableById(order.getDiningTableId());
		
		return orderDetailsByTable(diningTable.getTableNumber());
		
	}
	
		
	
	@GetMapping("editOrder:id={id}")
	public ModelAndView editOrder(@PathVariable int id) {
		
		Order order = orderService.getOrder(id);
		DiningTable diningTable = diningTableService.getDiningTableById(order.getDiningTableId());
		Employee attendant = employeeService.getEmployeeById(order.getAttendantId());
		
		DisplayOrder displayOrder = new DisplayOrder(
				order.getId(),
				diningTable.getTableNumber(),
				attendant.getFirstName() + " " + attendant.getLastName(),
				order.getSubTotal(),
				order.getTax(),
				order.getTotal(),				
				order.getCreatedDate(),
				order.isBillPaid()
				);
		
		ModelAndView mv = new ModelAndView("order/editOrder");
		mv.addObject("displayOrder", displayOrder);
		
		return mv;

	}
	
	
	@RequestMapping("/updateOrder")
	public String updateOrder(DisplayOrder displayOrder) {
		
		DiningTable diningTable = diningTableService.getDiningTableByTableNumber(displayOrder.getDiningTableNumber());
		String[] attendantName = displayOrder.getAttendant().split(" ");
		Employee attendant = employeeService.getEmployeeByName(attendantName[0], attendantName[1]);
		
		Order order = new Order();
		order.setId(displayOrder.getId());
		order.setDiningTableId(diningTable.getId());
		order.setAttendantId(attendant.getId());
		order.setSubTotal(displayOrder.getSubTotal());
		order.setTax(displayOrder.getTax());
		order.setTotal(displayOrder.getTotal());
		order.setBillPaid(displayOrder.isBillPaid());
		
		orderService.updateOrder(order);
		
		return "redirect:/unpaidOrders";
	}
	
	
	@RequestMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable int id) {
				
		orderService.deleteOrder(id);
		
		return "redirect:/unpaidOrders";
	}	

}
