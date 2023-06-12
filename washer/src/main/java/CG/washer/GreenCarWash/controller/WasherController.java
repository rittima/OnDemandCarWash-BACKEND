package CG.washer.GreenCarWash.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import CG.washer.GreenCarWash.config.JwtUtil;
import CG.washer.GreenCarWash.exceptionHandlers.APIrequestException;
import CG.washer.GreenCarWash.model.AuthenticationRequest;
import CG.washer.GreenCarWash.model.AuthenticationResponse;
import CG.washer.GreenCarWash.model.MessageResponse;
import CG.washer.GreenCarWash.model.OrderDetails;
import CG.washer.GreenCarWash.model.User1;
import CG.washer.GreenCarWash.model.WashPacks;
import CG.washer.GreenCarWash.repo.OrderRepo;
import CG.washer.GreenCarWash.repo.UserRepo;
import CG.washer.GreenCarWash.service.MyUserDetailsService;
import CG.washer.GreenCarWash.service.OrderService;
import CG.washer.GreenCarWash.service.SequenceDao;
import CG.washer.GreenCarWash.service.WashPackService;


@RestController
@CrossOrigin(origins="*",methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE
    })
@RequestMapping("/washers")
public class WasherController {
    @Autowired
    WashPackService wr;
    @Autowired
    OrderService os;
    @Autowired
    OrderRepo or;

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService ;
	
	@Autowired
	private AuthenticationManager auth;
    

    /** Only the methods that consume rest template are below this comment **/
    //To see the Unassigned orders
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return wr.getUnassignedOrders();
    }
    
  //To see all the wash packs
    @GetMapping("/seeWP")
    public List<WashPacks> getAllWP(){
        return wr.getAllWP();
    }
    
    
    @PutMapping("/updateStatus/{orderId}")
    public ResponseEntity<OrderDetails> updateStatus(@PathVariable Long orderId){
        OrderDetails existingOrder=or.findById(orderId).orElseThrow(() -> new APIrequestException("Order with ID -> "+orderId+" not found, status update failed"));
        existingOrder.setStatus("Completed");
        OrderDetails order=or.save(existingOrder);
        return ResponseEntity.ok(order);
    }
    
//    //To assign a washer to the order by washer
//    @PutMapping("/assign")
//    public OrderDetails assignSelf(@RequestBody OrderDetails orderDetails){
//        return wr.assignSelf(orderDetails);
//    }
//    
    @PutMapping("/assignWasher")
    public OrderDetails assignWasher(@RequestBody OrderDetails od){
        boolean doesOrderExists=or.existsById(od.getOrderId());
        OrderDetails existingOrder = or.findById(od.getOrderId()).orElse(null);
        if (doesOrderExists && existingOrder.getWasherName().contains("NA")){
            existingOrder.setWasherName(od.getWasherName());
            return or.save(existingOrder);
        }
        else {
            throw new APIrequestException("Order not found in database, washer not assigned");
        }
    }
    
//    
//    @PostMapping("/addOrder")
//    public OrderDetails addOrder(@RequestBody OrderDetails orderDetails){
//        return os.addOrder(orderDetails);
//    }

//----------------SECURITY-------------------------------

@PostMapping("/register")
private ResponseEntity<?> subscribe( @RequestBody AuthenticationRequest request)
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
    
    try 
    {
        repo.save(model);
    }
    catch (Exception e) 
    {
        return ResponseEntity.ok(new AuthenticationResponse("Error while subsribing the user with username "+ username));
    }
        return ResponseEntity.ok(new AuthenticationResponse("client subscribed with username "+username));
}

//@RequestMapping(value="/login", method=RequestMethod.POST)
@PostMapping("/login")
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
    try
    {
    auth.authenticate(
            new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
}
    catch (BadCredentialsException e) {
         new Exception("Incorrect username or password", e);
    }

    final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getUsername());

    final String jwt = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticationResponse(jwt));
}
}
	
	

