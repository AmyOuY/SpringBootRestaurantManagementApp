package com.ouym.restaurantmanager.model;

import java.time.LocalDateTime;

public class DisplayOrder {

	private int id;
	private int diningTableNumber;
	private String attendant;
	private double subTotal;
	private double tax;
	private double total;	
	private LocalDateTime createdDate;
	private boolean billPaid;	
	
	public DisplayOrder(int id, int diningTableNumber, String attendant, double subTotal, double tax, double total,
			LocalDateTime createdDate, boolean billPaid) {
		super();
		this.id = id;
		this.diningTableNumber = diningTableNumber;
		this.attendant = attendant;
		this.subTotal = subTotal;
		this.tax = tax;
		this.total = total;		
		this.createdDate = createdDate;
		this.billPaid = billPaid;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
