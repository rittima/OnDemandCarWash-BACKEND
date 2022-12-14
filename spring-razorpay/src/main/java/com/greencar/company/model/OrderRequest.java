package com.greencar.company.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CustomerDetails")
public class OrderRequest {
	
	@Id
	String id;
	String customerName;
	String email;
	String phoneNumber;
	Integer amount;
	
	public OrderRequest(String id, String customerName, String email, String phoneNumber, Integer amount) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
