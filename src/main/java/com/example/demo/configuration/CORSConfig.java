package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/list")
				.allowedOrigins("http://localhost:8080", "http://localhost:8100", "https://clinicasur.herokuapp.com")
				.allowedMethods("GET")
				.maxAge(3600)
				.allowedHeaders("Authorization");
				
				registry.addMapping("/authRest/loginRest")
				.allowedOrigins("http://localhost:8080", "http://localhost:8100", "https://clinicasur.herokuapp.com")
				.allowCredentials(true)
				.allowedMethods("POST")
				.maxAge(3600);
			}
		};
	}
}
