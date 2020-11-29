package com.iiitb.examAdminBackEnd.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String userName){
		return userRepository.findByUserName(userName);
	}
}
