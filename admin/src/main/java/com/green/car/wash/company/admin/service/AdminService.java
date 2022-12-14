package com.green.car.wash.company.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.company.admin.WrapperModel.WasherRatings;
import com.green.car.wash.company.admin.model.OrderDetails;
import com.green.car.wash.company.admin.model.Ratings;
import com.green.car.wash.company.admin.model.UserDETAILS;

import java.util.Arrays;

@Service
public class AdminService {

	@Autowired
	private RestTemplate restTemplate;


	String url="http://ORDER-SERVICE/orders";

	//Url to access the methods of User Service
	String url2="http://USER-SERVICE/users";
        
	/** Order controls through admin using rest template*/
	//To assign a washer to the order by Admin
	public  OrderDetails assignWasher(OrderDetails orderDetails)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails,headers);
		return  restTemplate.exchange(url+"/assignWasher", HttpMethod.PUT,assignedWasher,OrderDetails.class).getBody();
	}

	/** Washer controls through admin using rest template*/
	//To get a single washer
	public UserDETAILS getOneWasher(String name) {
		return restTemplate.getForObject(url+"/washers/"+name,UserDETAILS.class);

	}
	//To get the details of Washers with all their reviews

	public WasherRatings washerSpecificRatings(String washerName){
		//Using a wrapper-class here to get 2 json in one
		UserDETAILS wd =restTemplate.getForObject(url+"/washers/"+washerName,UserDETAILS.class);//url4
		Ratings[] ratingsList=restTemplate.getForObject(url2+"/washerSpecificRating/"+washerName,Ratings[].class);//url2
		//Wrapping into a "Proxy class"

		return new WasherRatings(wd.getId(),wd.getFullname(),wd.getEmail(),Arrays.asList(ratingsList));
	}}

									 