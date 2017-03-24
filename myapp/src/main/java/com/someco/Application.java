package com.someco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.someco.config.JpaConfig;

@SpringBootApplication
@ComponentScan
public class Application{
	
	public static void main(String[] args) {
		//SpringApplication.run(new Class<?>[] { Application.class, JpaConfig.class }, args);
		SpringApplication.run(Application.class, args);
	}
}
