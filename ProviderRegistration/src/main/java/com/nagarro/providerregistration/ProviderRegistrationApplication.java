package com.nagarro.providerregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderRegistrationApplication.class, args);
	}

}
