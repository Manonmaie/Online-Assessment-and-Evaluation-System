package com.iiitb.assessmentBackEnd.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean checkUserValidOrNot(String userName, String password) {
		AsUser user = userRepository.findByUserNameAndPassword(userName, password);
		if(user==null) {
			return false;
		}
		return true;
	}
	
}
