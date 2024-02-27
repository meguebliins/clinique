package com.ins.clinique;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class CliniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliniqueApplication.class, args);
	}

}
