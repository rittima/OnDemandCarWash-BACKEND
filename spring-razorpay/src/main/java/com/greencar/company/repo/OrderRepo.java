package com.greencar.company.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greencar.company.model.OrderResponse;
@Repository
public interface OrderRepo extends MongoRepository<OrderResponse, String> {

}
