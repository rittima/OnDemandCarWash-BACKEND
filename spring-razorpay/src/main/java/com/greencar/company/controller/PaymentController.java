package com.greencar.company.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.greencar.company.model.OrderRequest;
import com.greencar.company.model.OrderResponse;
import com.greencar.company.repo.OrderRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
    private OrderRepo or;

	private RazorpayClient client;
	private static final String SECRET_ID1 = "rzp_test_fyfCD9YzONnPTI";
	private static final String SECRET_KEY1 = "3YUigmguDhOUHmlrBNAGO0CY";
	
	
	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse response = new OrderResponse();
		try {

			if (orderRequest.getAmount().intValue() > 5000) {
				client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);
			} else {
				System.out.println("amount should be less than 5000");
			}
			

			String order = createRazorPayOrder(orderRequest.getAmount());
			System.out.println("---------------------------");
			String orderId = order("id");
			System.out.println("Order ID: " + orderId);
			System.out.println("---------------------------");
			response.setRazorpayOrderId(orderId);
			response.setApplicationFee(" " + orderRequest.getAmount());
			if (orderRequest.getAmount().intValue() > 5000) {
				response.setSecretKey(SECRET_KEY1);
				response.setSecretId(SECRET_ID1);
				response.setPaymentName("razor1");
			} else {
				System.out.println("amount should be less than 5000");
			}
			return response;
		} catch (RazorpayException e) {
			e.printStackTrace();
		}

		return response;

	}
	
	private String order(String string) {
		
		return null;
	}

	@GetMapping("/findall")
    public List<OrderResponse> findallOrders(){
        return or.findAll();
    }

	private String createRazorPayOrder(Integer amount) throws RazorpayException {

		JSONObject options = new JSONObject();
		options.put("amount",10);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		options.put("payment_capture", 1); // You can enable this if you want to do Auto Capture.
		return createRazorPayOrder(amount);
	}
}