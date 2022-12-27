package com.payment.PaymentIntegration.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.*;
import com.razorpay.RazorpayException;

@RestController
public class PaymentController {
	
//	@RequestMapping("/")
//	public String home() {
//		return "index.html";
//	}
	
	@PostMapping("/create_order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {
		System.out.println(data);
		int amt = Integer.parseInt(data.get("amount").toString());
		
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_qWKyx5bSK2NFxt", "1dbImMy6grkyb7rG1K5wV9Bn");
		
		JSONObject options = new JSONObject();
		options.put("amount", amt*100);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order = razorpayClient.Orders.create(options);
		System.out.println(order);
		
		return order.toString();
	}



}
