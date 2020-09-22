package com.iiitb.assessmentBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class AssessmentBackEndApplication {
	
	@RequestMapping("/")
    String home() {
        return "Helloo World!";
    }

	public static void main(String[] args) {
		SpringApplication.run(AssessmentBackEndApplication.class, args);
	}

}
