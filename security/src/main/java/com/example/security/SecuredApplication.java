package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SecuredApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredApplication.class, args);
	}

}
