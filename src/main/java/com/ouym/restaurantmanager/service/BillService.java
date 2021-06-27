package com.ouym.restaurantmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.Bill;
import com.ouym.restaurantmanager.repository.BillRepository;

@Service
public class BillService {
	
	@Autowired
	private BillRepository repo;

	@Autowired
	private OrderService orderService;
	
	
	public Bill addBill(Bill bill) {
		
		orderService.updateBillPaidInfo(bill.getOrderId());
		orderService.updateBillPaidInfo(bill.getDiningTableId(), bill.getOrderId());
		
		return repo.save(bill);
	}
	
	
	public List<Bill> getPaidBills(){
		
		return repo.findAllByBillPaid(true);
	}
	
}
