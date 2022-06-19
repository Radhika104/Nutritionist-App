package com.stackroute.nutritionist.recommendedfoodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RecommendedfoodserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendedfoodserviceApplication.class, args);
	}

}
