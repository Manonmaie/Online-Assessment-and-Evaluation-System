package com.iiitb.examAdminBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class ExamAdminBackEndApplication {
	
	@RequestMapping("/test")
	String home() {
		return "Hello World!";
	}
	public static void main(String[] args) {
		SpringApplication.run(ExamAdminBackEndApplication.class, args);
	}

}
