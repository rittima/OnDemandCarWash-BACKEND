package com.green.car.wash.company.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.company.order.model.OrderDetails;
@Repository
public interface OrderRepo extends MongoRepository<OrderDetails, String> {

}
