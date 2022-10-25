package com.sahu.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {
	
	@Autowired
	private LoadBalancerClient client; //Comes through AutoConfiguration
	
	public String getBillingInfo() {
		//Get less Load factor Service instances
		ServiceInstance si = client.choose("Billing-Service");
		//get Producer MS URI and make it as URL
		String url = si.getUri()+"/billing/info";
		//Create RestTemplate object 
		RestTemplate restTemplate = new RestTemplate();
		//invoke producer MS service method/ operation by generating HTTP call
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}
	
}

