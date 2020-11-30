package com.iiitb.evaluationBackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiitb.evaluationBackend.user.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/username/{userName}/password/{password}/user")
	public boolean checkUserValidOrNot(@PathVariable String userName, @PathVariable String password){
		return userService.checkUserValidOrNot(userName, password);
	}
}
