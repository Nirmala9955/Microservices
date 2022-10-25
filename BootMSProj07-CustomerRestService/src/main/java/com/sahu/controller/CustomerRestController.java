package com.sahu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerRestController {

	@GetMapping("/display")
	public String diplayData() {
		return "Customer info will be display here, Welcome to call center";
	}
	
}
