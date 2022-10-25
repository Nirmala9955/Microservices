package com.sahu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
@RefreshScope
public class CustomerOperationsController {

	@Value("${dbuser}")
	private String user;
	
	@Value("${dbpwd}")
	private String pass;
	
	@GetMapping("/show")
	public String showData() {
		return "(Customer) Data collecte through Config server - "+user+" - "+pass;
	}
}
