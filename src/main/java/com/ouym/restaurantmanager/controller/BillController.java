package com.ouym.restaurantmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.Bill;
import com.ouym.restaurantmanager.model.DiningTable;
import com.ouym.restaurantmanager.model.DisplayBill;
import com.ouym.restaurantmanager.model.DisplayOrderDetail;
import com.ouym.restaurantmanager.model.Employee;
import com.ouym.restaurantmanager.model.Food;
import com.ouym.restaurantmanager.model.Message;
import com.ouym.restaurantmanager.model.Order;
import com.ouym.restaurantmanager.model.OrderDetail;
import com.ouym.restaurantmanager.service.BillService;
import com.ouym.restaurantmanager.service.DiningTableService;
import com.ouym.restaurantmanager.service.EmployeeService;
import com.ouym.restaurantmanager.service.FoodService;
import com.ouym.restaurantmanager.service.OrderService;

@Controller
public class BillController {
	
	@Autowired 
	private BillService billService;
	
	@Autowired
	private OrderService orderService;
		
	@Autowired
	private DiningTableService diningTableService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private FoodService foodService;
	
	
	@GetMapping("/billByTable")
	@ResponseBody
	public ModelAndView billByTable(@RequestParam int tableNumber) {
		
		ModelAndView mv = new ModelAndView();
		
		if (diningTableService.validDiningTable(tableNumber) == false) {
			
			Message message = new Message("Error! Table Number " + tableNumber + " does not exist!");
			mv.setViewName("home/alert");
			mv.addObject("message", message);
			
			return mv;
		}
		else {
			
			DiningTable diningTable = diningTableService.getDiningTableByTableNumber(tableNumber);						
			Order order = orderService.getUnpaidOrderByDiningTableId(diningTable.getId());
			List<OrderDetail> orderDetails = orderService.getUnpaidOrderDetailsByDiningTableId(diningTable.getId());
			
			if (order == null || orderDetails == null) {
				Message message = new Message("Error! There is no currently active order for Table " + tableNumber);
				mv.setViewName("home/alert");
				mv.addObject("message", message);
				
				return mv;
			}			
			
			Employee attendant = employeeService.getEmployeeById(order.getAttendantId());
			
			DisplayBill bill = new DisplayBill(
					order.getId(),
					diningTable.getTableNumber(),
					attendant.getFirstName() + " " + attendant.getLastName(),
					order.getSubTotal(),
					order.getTax(),
					order.getTotal(),
					order.isBillPaid()
					);
						
			for (OrderDetail orderDetail : orderDetails) {
				Food food = foodService.getFoodById(orderDetail.getFoodId());
				
				bill.getOrderDetails().add(
						new DisplayOrderDetail(
							orderDetail.getId(),
							tableNumber,
							attendant.getFirstName() + " " + attendant.getLastName(),
							food.getFoodName(),
							food.getPrice(),
							orderDetail.getQuantity(),
							orderDetail.getCreatedDate(),
							orderDetail.getOrderId()
						)
					);
			}
			
			mv.setViewName("bill/billByTable");
			mv.addObject("bill", bill);
			
			return mv;
			
		}
	}
	
	
	
	@RequestMapping("/searchBillByTable")
	public String searchBillByTable() {
		
		return "bill/searchBillByTable";
	}
	
	
	
	@RequestMapping("/payBill")
	public ModelAndView payBill(DisplayBill displayBill) {
		
		DiningTable diningTable = diningTableService.getDiningTableByTableNumber(displayBill.getDiningTableNumber());
		String[] attendantName = displayBill.getAttendant().split(" ");
		Employee attendant = employeeService.getEmployeeByName(attendantName[0], attendantName[1]);
		
		Bill bill = new Bill();
				
		bill.setOrderId(displayBill.getOrderId());
		bill.setDiningTableId(diningTable.getId());
		bill.setAttendantId(attendant.getId());
		bill.setSubTotal(displayBill.getSubTotal());
		bill.setTax(displayBill.getTax());
		bill.setTotal(displayBill.getTotal());
		bill.setBillPaid(true);
		
		billService.addBill(bill);
		
		Message message = new Message("Successfully Pay Bill for Table " + diningTable.getTableNumber());
		ModelAndView mv = new ModelAndView("home/alert");
		mv.addObject("message", message);
		
		return mv;
				
	}
	
	
	@GetMapping("/paidBills")
	public ModelAndView getPaidBills() {
		
		List<Bill> bills = billService.getPaidBills();
		List<DisplayBill> displayBills = new ArrayList<>();
		
		for (Bill bill : bills) {
			
			DiningTable diningTable = diningTableService.getDiningTableById(bill.getDiningTableId());
			Employee attendant = employeeService.getEmployeeById(bill.getAttendantId());
			
			displayBills.add(
					new DisplayBill(
							bill.getOrderId(),
							diningTable.getTableNumber(),
							attendant.getFirstName() + " " + attendant.getLastName(),
							bill.getSubTotal(),
							bill.getTax(),
							bill.getTotal(),
							bill.isBillPaid()
						)
				);	
			
		}
		
		ModelAndView mv = new ModelAndView("bill/paidBills");
		mv.addObject("displayBills", displayBills);
		
		return mv;
				
	}
}
