package com.mindcraft.AccountServiceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceDemoApplication.class, args);
	}

}
