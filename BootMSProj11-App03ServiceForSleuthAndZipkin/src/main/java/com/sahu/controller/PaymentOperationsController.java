package com.sahu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentOperationsController {
	
	Logger logger = LoggerFactory.getLogger(PaymentOperationsController.class);

	@GetMapping("/payment")
	public String doPayment() {
		logger.info("Welcome to Payment module");
		return "Payment is done";
	}
	
}
