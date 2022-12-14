package com.sahu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.client.IBillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

	@Autowired
	private IBillingServiceRestConsumer consumer;
	
	@GetMapping("/info")
	public String displayShoppingDetails() {
		return "Pongal Shopping for family  .... "+consumer.fetchBillDetails();
	}
	
}
