package com.ouym.restaurantmanager.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	private int id;
	private int diningTableId;
	private int attendantId;
	private double subTotal;
	private double tax;
	private double total;
	private boolean billPaid;
		
	@Column(name = "created_date")
	private LocalDateTime createdDate = LocalDateTime.now();;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiningTableId() {
		return diningTableId;
	}

	public void setDiningTableId(int diningTableId) {
		this.diningTableId = diningTableId;
	}

	public int getAttendantId() {
		return attendantId;
	}

	public void setAttendantId(int attendantId) {
		this.attendantId = attendantId;
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
