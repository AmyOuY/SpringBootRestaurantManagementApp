package com.ouym.restaurantmanager.model;

import java.util.ArrayList;
import java.util.List;

public class DisplayBill {

	private int orderId;
	private int diningTableNumber;
	private String attendant;
	private double subTotal;
	private double tax;
	private double total;
	private boolean billPaid; 
	
	private List<DisplayOrderDetail> orderDetails = new ArrayList<>();

	public DisplayBill(int orderId, int diningTableNumber, String attendant, double subTotal, double tax, double total,
			boolean billPaid) {
		super();
		this.orderId = orderId;
		this.diningTableNumber = diningTableNumber;
		this.attendant = attendant;
		this.subTotal = subTotal;
		this.tax = tax;
		this.total = total;
		this.billPaid = billPaid;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getDiningTableNumber() {
		return diningTableNumber;
	}

	public void setDiningTableNumber(int diningTableNumber) {
		this.diningTableNumber = diningTableNumber;
	}

	public String getAttendant() {
		return attendant;
	}

	public void setAttendant(String attendant) {
		this.attendant = attendant;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isBillPaid() {
		return billPaid;
	}

	public void setBillPaid(boolean billPaid) {
		this.billPaid = billPaid;
	}

	public List<DisplayOrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<DisplayOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
