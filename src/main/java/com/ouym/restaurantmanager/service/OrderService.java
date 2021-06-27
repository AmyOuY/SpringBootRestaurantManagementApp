package com.ouym.restaurantmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.Employee;
import com.ouym.restaurantmanager.model.FillInOrderDetail;
import com.ouym.restaurantmanager.model.Food;
import com.ouym.restaurantmanager.model.Order;
import com.ouym.restaurantmanager.model.OrderDetail;
import com.ouym.restaurantmanager.repository.OrderDetailRepository;
import com.ouym.restaurantmanager.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderDetailRepository orderDetailRepo;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private EmployeeService employeeService;
	
	private double taxRate = 0.15;
	

	
	public OrderDetail addOrderDetail(FillInOrderDetail fillInOrderDetail) {
		
		String[] attendantName = fillInOrderDetail.getAttendant().split(" ");
		Employee attendant = employeeService.getEmployeeByName(attendantName[0], attendantName[1]);
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setDiningTableId(fillInOrderDetail.getDiningTableId());
		orderDetail.setAttendantId(attendant.getId());
		orderDetail.setFoodId(fillInOrderDetail.getFoodId());
		orderDetail.setQuantity(fillInOrderDetail.getQuantity());
		
		return orderDetailRepo.save(orderDetail);
	}
	
	
	
	public OrderDetail getOrderDetailById(int id) {
		
		return orderDetailRepo.findById(id).orElse(null);
	}
	
	
	public List<OrderDetail> getOrderDetails(){
		
		return orderDetailRepo.findAll();
		
	}
	
	
	public List<OrderDetail> getUnpaidOrderDetailsByDiningTableId(int diningTableId) {
		
		return orderDetailRepo.findByDiningTableIdAndOrderId(diningTableId, 0);
		
	}
	
	
	public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
		
		return orderDetailRepo.save(orderDetail);
	}
	
	
	public String deleteOrderDetail(int id) {
		
		orderDetailRepo.deleteById(id);
		
		return "Successfully deleted order detail: " + id;
	}
	
	
	public Order addOrderByTableId(int diningTableId) {
		List<OrderDetail> orderDetails = getUnpaidOrderDetailsByDiningTableId(diningTableId);
				
		if (orderDetails == null) return null;
		
		Order order = new Order();
		
		order.setDiningTableId(diningTableId);
		order.setAttendantId(orderDetails.get(0).getAttendantId());
		
		for (OrderDetail detail : orderDetails) {
			
			Food food = foodService.getFoodById(detail.getFoodId());
			
			order.setSubTotal(order.getSubTotal() + detail.getQuantity() * food.getPrice());
		}
		
		order.setTax(Math.round(order.getSubTotal() * taxRate * 100.0) / 100.0);
		order.setTotal(order.getSubTotal() + order.getTax());
		
		return orderRepo.save(order);
	}
	
	
	public Order getOrder(int id) {
		
		return orderRepo.findById(id).orElse(null);
	}
	
	
	public List<Order> getOrders(){
		
		return orderRepo.findAll();
		
	}
	
	
	public List<Order> getUnpaidOrders(boolean billPaid){
		
		return orderRepo.findByBillPaid(billPaid);
	}
	
	
	public Order getUnpaidOrderByDiningTableId(int diningTableId) {
		
		return orderRepo.findByDiningTableIdAndBillPaid(diningTableId, false);
	}
	
	
	public Order updateOrder(Order order) {
		
		return orderRepo.save(order);
	}
	
	
	public String deleteOrder(int id) {
		
		orderRepo.deleteById(id);
		
		return "Successfully deleted order: " + id;
	}
	
	
	public Order updateBillPaidInfo(int id) {
		
		Order existingOrder = orderRepo.findById(id).orElse(null);
		
		if (existingOrder == null) return null;
		
		existingOrder.setBillPaid(true);
		
		return orderRepo.save(existingOrder);
	}
	
	
	public void updateBillPaidInfo(int diningTableId, int orderId) {
		
		List<OrderDetail> orderDetails = getUnpaidOrderDetailsByDiningTableId(diningTableId);
		
		for (OrderDetail detail : orderDetails) {
			detail.setOrderId(orderId);			
			orderDetailRepo.save(detail);
		}
		
	}
}
