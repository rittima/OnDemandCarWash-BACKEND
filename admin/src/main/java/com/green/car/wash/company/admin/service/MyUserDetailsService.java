package com.green.car.wash.company.admin.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.car.wash.company.admin.model.User1;
import com.green.car.wash.company.admin.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User1 user = repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found with usernmae : "+username);
		}
		String name =user.getUsername();
		String password = user.getPassword();
		return new User(name,password,new ArrayList<>());
		
		
	}

}


