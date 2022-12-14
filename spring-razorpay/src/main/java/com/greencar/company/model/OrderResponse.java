package com.greencar.company.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PaymentDetails")
public class OrderResponse {

	String secretKey;
	String razorpayOrderId;
	String applicationFee;
	String secretId;
	String paymentName;
	
	public OrderResponse(String secretKey, String razorpayOrderId, String applicationFee, String secretId, String paymentName) {
		super();
		this.secretKey = secretKey;
		this.razorpayOrderId = razorpayOrderId;
		this.applicationFee = applicationFee;
		this.secretId = secretId;
		this.paymentName = paymentName;
	}
	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	public String getApplicationFee() {
		return applicationFee;
	}
	public void setApplicationFee(String applicationFee) {
		this.applicationFee = applicationFee;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
	
}
