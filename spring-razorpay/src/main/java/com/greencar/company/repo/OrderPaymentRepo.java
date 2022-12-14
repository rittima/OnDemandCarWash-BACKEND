package com.greencar.company.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greencar.company.model.OrderRequest;
import com.greencar.company.model.OrderResponse;
import com.razorpay.Order;


@Repository
public interface OrderPaymentRepo extends MongoRepository<OrderRequest, String> {

	OrderRequest insert(Order order);

}
