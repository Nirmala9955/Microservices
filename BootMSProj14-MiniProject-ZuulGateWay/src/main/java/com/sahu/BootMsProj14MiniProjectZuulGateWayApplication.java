package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class BootMsProj14MiniProjectZuulGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj14MiniProjectZuulGateWayApplication.class, args);
	}

}
