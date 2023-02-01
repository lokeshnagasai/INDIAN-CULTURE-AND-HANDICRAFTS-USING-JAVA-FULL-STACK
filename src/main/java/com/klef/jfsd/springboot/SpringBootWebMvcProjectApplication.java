package com.klef.jfsd.springboot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.klef.jfsd.springboot")
public class SpringBootWebMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcProjectApplication.class, args);
		System.out.println("Spring Boot Web MVC");
	}
	

}
