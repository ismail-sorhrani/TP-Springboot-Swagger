package com.isic2.tp.shool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.isic2.tp.entities")
@EnableJpaRepositories(basePackages = "com.isic2.tp.repository")
@ComponentScan(basePackages = {"com.isic2.tp.service", "com.isic2.tp.controller"})
public class ShoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoolApplication.class, args);
	}

}
