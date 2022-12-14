package com.green.car.wash.company.admin.repository;



import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.green.car.wash.company.admin.model.User1;





@Repository
public interface UserRepo  extends MongoRepository<User1, Integer>
{
	User1 findByUsername(String username);
    
	Boolean existsByUsername(String username);
 
}
