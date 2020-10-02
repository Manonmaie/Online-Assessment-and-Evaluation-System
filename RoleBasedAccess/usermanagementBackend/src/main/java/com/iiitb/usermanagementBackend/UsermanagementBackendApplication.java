package com.iiitb.usermanagementBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.dao.UserDao;
import com.iiitb.model.User;
 
@SpringBootApplication
//@RestController
//@EnableAutoConfiguration
public class UsermanagementBackendApplication {
	
//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(UsermanagementBackendApplication.class, args);
	}

//    @Bean
//    public CommandLineRunner init(UserDao userDao){
//        return args -> {
//            User user1 = new User();
//            user1.setUsername("harsha");
//            user1.setPassword(passwordEncoder.encode("harsha"));
//            userDao.save(user1);
//
//            User user2 = new User();
//            user2.setUsername("sriharsha");
//            user2.setPassword(passwordEncoder.encode("sriharsha"));
//            userDao.save(user2);
//        };
//    }
}
