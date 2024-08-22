package com.practice.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class AppDoc {

	Info info() {
		return new Info().title("Library Management System - Restful API")
				.version("v1")
				.description("Rest API");
	}
	
	@Bean
	OpenAPI OpenApi() {
	return new OpenAPI().info(info());
	}
}
