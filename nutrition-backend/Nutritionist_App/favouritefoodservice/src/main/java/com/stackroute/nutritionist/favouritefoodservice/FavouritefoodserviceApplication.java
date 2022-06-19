package com.stackroute.nutritionist.favouritefoodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient
public class FavouritefoodserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouritefoodserviceApplication.class, args);
	}
	
	@GetMapping("/fav/{msg}")
	public ResponseEntity<String> echo(@PathVariable String msg) {
		return new ResponseEntity<String>("Your alert message, ", HttpStatus.OK);
	}

}
