package com.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBoootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoootApplication.class, args);
	}

}
