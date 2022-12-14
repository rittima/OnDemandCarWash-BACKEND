package com.green.car.wash.company.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.green.car.wash.company.customer.models.Ratings;
import com.green.car.wash.company.customer.models.customerDetails;
import com.green.car.wash.company.customer.repository.CustomerRepo;
import com.green.car.wash.company.customer.service.CustomerService;
import com.green.car.wash.company.customer.service.RatingsService;

@RestController
@RequestMapping("/users")
public class customerController {
	@Autowired
	private CustomerRepo customerrepo;
	@Autowired
	private RatingsService ratingservice;
	@Autowired
	private CustomerService customerservice;

	
	@PostMapping("/addRating")
    public Ratings addRating(@RequestBody Ratings ratings){
        return ratingservice.addRating(ratings);
    }
	@GetMapping("/getallRatings")
    public List<Ratings> getallratings(){
        return ratingservice.getallRatings();
    }
	@GetMapping("/washerSpecificRating/{washerName}")
    public List<Ratings> washerSpecificRating(@PathVariable String washerName){
        return ratingservice.washerSpecific(washerName);
	}
    @PostMapping("/addDetails")
    public customerDetails addDetails(@RequestBody customerDetails details)
    {
    	return customerservice.addDetails(details);
    }
    @PutMapping("/update/{Id}")
    public ResponseEntity updateDetails(@PathVariable String Id ,@RequestBody customerDetails details)
    {
    	customerservice.updateDetails(details);
    	return ResponseEntity.ok().build();
    }
    
    //delete the 
    @DeleteMapping("/delete/{id}")
    public void deleteproduct(@PathVariable String id)
    {
        customerrepo.deleteById(id);

    }
    //
    @GetMapping("/{id}")
    public List<customerDetails> customerSpecific(@PathVariable String id){
        return customerservice.CustomerSpecific(id);
	}

    }



