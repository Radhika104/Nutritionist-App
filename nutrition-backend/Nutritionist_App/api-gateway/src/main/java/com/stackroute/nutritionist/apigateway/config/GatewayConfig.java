package com.stackroute.nutritionist.apigateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stackroute.nutritionist.apigateway.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

    @Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("userservice", r -> r.path("/userservice/**") .filters(f -> f.filter(filter))
                .uri("lb://userservice"))
				.route("fav", r -> r.path("/fav/**").filters(f -> f.filter(filter))
                        .uri("lb://fav")).build();
	}

}
