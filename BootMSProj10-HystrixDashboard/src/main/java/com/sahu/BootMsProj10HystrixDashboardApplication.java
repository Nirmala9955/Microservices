package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class BootMsProj10HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj10HystrixDashboardApplication.class, args);
	}

}
