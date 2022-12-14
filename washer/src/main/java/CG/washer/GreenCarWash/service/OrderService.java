package CG.washer.GreenCarWash.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import CG.washer.GreenCarWash.exceptionHandlers.API_requestException;
import CG.washer.GreenCarWash.model.OrderDetails;
import CG.washer.GreenCarWash.model.WashPacks;
import CG.washer.GreenCarWash.wrapperclass.OrderReceipt;

@Service
public class OrderService {
	 @Autowired
     private RestTemplate restTemplate;



     //Url to access the methods of Order Service
     String url="http://Order-Service/orders";
     //Url to access the methods of admin Service
     String url1="http://Admin-Service/admins";



     //To see all the WashPacks
     public List<WashPacks> getAllWP(){
         WashPacks[] wp=restTemplate.getForObject(url+"/findallWP",WashPacks[].class);
         return (Arrays.asList(wp));
     }



     /** Only the methods that use rest template are below this comment**/
     //To add an order from User-end
     public OrderDetails addOrder(OrderDetails orderDetails){
         HttpEntity<OrderDetails> addOrderbyUser = new HttpEntity<>(orderDetails);
         return restTemplate.postForObject(url+"/add",addOrderbyUser,OrderDetails.class);
     }
     //To update an order from User-end
     //This won't update the status of order
     public OrderDetails updateOrder(OrderDetails orderDetails){
         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<OrderDetails> updatedOrder = new HttpEntity<>(orderDetails,headers);
         return restTemplate.exchange(url+"/update", HttpMethod.PUT,updatedOrder,OrderDetails.class).getBody();
     }
     //To cancel the Order from user end
     public String cancelOrder(OrderDetails orderDetails){
         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<OrderDetails> cancelledOrder = new HttpEntity<>(orderDetails,headers);
         ResponseEntity<String> response=restTemplate.exchange(url+"/cancelOrder",HttpMethod.PUT,cancelledOrder,String.class);
         return response.getBody();
     }
     //To get the receipt of the order after order is completed
     public OrderReceipt getReceipt(String id){
         OrderDetails od=restTemplate.getForObject(url+"/findone/"+id,OrderDetails.class);
         WashPacks wp=restTemplate.getForObject(url1+"/wpbyname/"+od.getWashpack(),WashPacks.class);
         if(od.getStatus().contains("Completed")){
             return new OrderReceipt(id,od.getUseremailid(),od.getWasherName(),wp.getName(),wp.getDescription(),wp.getCost());
         }
         else{
             throw new API_requestException("Your order with ID -> "+id+" is still pending");
         }
     }
 

}
