package com.iiitb.examAdminBackEnd.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("user/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUser(userName);
	}
}
