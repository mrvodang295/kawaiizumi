package com.izumi.product.kawaiizumiwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.izumi")
@EnableAutoConfiguration
@SpringBootApplication
public class KawaiizumiWebAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KawaiizumiWebAppApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KawaiizumiWebAppApplication.class, args);
	}
}
