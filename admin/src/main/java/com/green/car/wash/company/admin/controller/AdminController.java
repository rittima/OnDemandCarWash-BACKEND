package com.green.car.wash.company.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.green.car.wash.company.admin.WrapperModel.WasherRatings;
import com.green.car.wash.company.admin.config.JwtUtil;
import com.green.car.wash.company.admin.model.*;
import com.green.car.wash.company.admin.repository.UserRepo;
import com.green.car.wash.company.admin.service.AdminService;
import com.green.car.wash.company.admin.service.MyUserDetailsService;
import com.green.car.wash.company.admin.service.WashPackService;
import com.green.car.wash.company.entity.User;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@Autowired
	WashPackService wps;

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService ;
	
	@Autowired
	private AuthenticationManager auth;
	
	/** Washer controls through admin using service object */
	// To find all the washpack
	@GetMapping("/findallWP")
	public List<WashPacks> findallWP() {
		return wps.findallWP();
	}

	// To find one WashPack with ID
	@GetMapping("/findoneWP/{id}")
	public ResponseEntity<WashPacks> findoneWP(@PathVariable String id) {
		return wps.findoneWP(id);
	}

	// To add a new WashPack
	@PostMapping("/addWP")
	public WashPacks addWP(@RequestBody WashPacks washPacks) {
		return wps.addWP(washPacks);
	}

	// To delete a Washpack
	@DeleteMapping("/deleteWP/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteWP(@PathVariable String id) {
		return wps.deleteWP(id);
	}

	// To update a Washpack
	@PutMapping("/updateWP/{id}")
	public ResponseEntity<WashPacks> updateWP(@PathVariable String id, @RequestBody WashPacks washPacks) {
		return wps.updateWP(id, washPacks);
	}

	// To find washpack with washpack name for user's reciept
	@GetMapping("/wpbyname/{name}")
    public WashPacks wpbyname(@PathVariable String name){
        return wps.findbyname(name);
    }

   /** Order controls through admin using rest template */

  //To assign a washer to the order by Admin
	
	  @PutMapping("/assignWasher") public OrderDetails assignWasher(@RequestBody
	  OrderDetails orderDetails){ return as.assignWasher(orderDetails); }
	 
  
 /** Washer controls through admin using rest template */

  //To get one washer
  
  @GetMapping("/oneWasher/{name}") public UserDETAILS getOneWasher(@PathVariable
  String name){ return as.getOneWasher(name); }
  
  //To get all the ratings of a specific Washer
  
  @GetMapping("/washerRating/{name}")
  public WasherRatings  washerSpecificRatings(@PathVariable String name)
  {
	  return as.washerSpecificRatings(name); }
  
 //----------------SECURITY-------------------------------
 
  @PostMapping("/register")
  private ResponseEntity<?> subscribe(@Valid @RequestBody AuthenticationRequest request)
  {
      if (repo.existsByUsername(request.getUsername())) {
          return ResponseEntity
                  .badRequest()
                  .body(new MessageResponse("Error: Username is already taken!"));
      }

      String username = request.getUsername();
      String password = request.getPassword();

      User1 model = new User1();
      model.setUsername(username);
      model.setPassword(password);
      try {
          repo.save(model);
      }
      catch (Exception e) {
          return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username " + username));
      }
          return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username " + username));
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
      try
      {
      auth.authenticate(
              new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
  }
      catch (BadCredentialsException e) {
          throw new Exception("Incorrect username or password", e);
      }

      final UserDetails userDetails = userDetailsService
              .loadUserByUsername(authenticationRequest.getUsername());

      final String jwt = jwtTokenUtil.generateToken(userDetails);

      return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
	
	
	