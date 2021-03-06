package com.xml.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.xml.web"})
public class SpringXMLApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringXMLApplication.class, args);
	}
}
