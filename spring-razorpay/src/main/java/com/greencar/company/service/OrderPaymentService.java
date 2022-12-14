package com.greencar.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencar.company.model.OrderRequest;
import com.greencar.company.repo.OrderPaymentRepo;
import com.razorpay.Order;

@Service
public class OrderPaymentService {
	
	@Autowired
    private OrderPaymentRepo opr;


	//To add a payment details
    public OrderRequest addOP(Order order){
        return opr.insert(order);
    }
}
