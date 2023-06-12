package CG.washer.GreenCarWash.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import CG.washer.GreenCarWash.model.User1;
import CG.washer.GreenCarWash.repo.UserRepo;


@Service
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	UserRepo repo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User1 user = repo.findByUsername(username);
		if(user==null) 
		{
			//throw new UsernameNotFoundException("User not found with usernmae : "+username);
			return null;
		}
		String name =user.getUsername();
		String pwd = user.getPassword();
		return new User(name,pwd,new ArrayList<>());
		
		
	}

	
}


