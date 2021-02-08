package com.example.demo;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Trabajo2evApplication {

	public static void main(String[] args) {
		SpringApplication.run(Trabajo2evApplication.class, args);
	}

	@Bean
	public DozerBeanMapper studentMapper() {
		return new DozerBeanMapper ();
	}
}
