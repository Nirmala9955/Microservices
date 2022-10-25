package com.sahu.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {
	
	@Autowired
	private DiscoveryClient client; //Comes through AutoConfiguration
	
	public String getBillingInfo() {
		//find and get Service instances of producer by using service id
		List<ServiceInstance> listSI = client.getInstances("Billing-Service");
		//use first ServiceInstance from the list of instances
		ServiceInstance si = listSI.get(0);
		//get Producer MS URI and make it as URL
		String url = si.getUri()+"/billing/info";
		//Create RestTemplate object 
		RestTemplate restTemplate = new RestTemplate();
		//invoke producer MS service method/ operation by generating HTTP call
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}
	
}

