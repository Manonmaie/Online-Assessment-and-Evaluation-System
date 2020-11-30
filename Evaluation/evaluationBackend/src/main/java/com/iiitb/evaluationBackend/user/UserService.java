package com.iiitb.evaluationBackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.user.EvUser;
import com.iiitb.evaluationBackend.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean checkUserValidOrNot(String userName, String password) {
		EvUser user = userRepository.findByUserNameAndPassword(userName, password);
		if(user==null) {
			return false;
		}
		return true;
	}
	
}