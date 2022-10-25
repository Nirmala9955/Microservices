package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootMsProj05CustomerRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05CustomerRestServiceApplication.class, args);
	}

}
