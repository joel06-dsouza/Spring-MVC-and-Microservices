package com.mindcraft.UPIServiceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UpiServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpiServiceDemoApplication.class, args);
	}


	/* Register the load-balanced RestTemplate in spring container */
	@Bean  /* spring controller invokes this mtd */
	@LoadBalanced /*
					 * configures the rest template calls, to use ribbion:client side load balancer
					 */
	public RestTemplate createTemplate(RestTemplateBuilder builder) {
		return builder.build(); /* creates template */
	}
}
