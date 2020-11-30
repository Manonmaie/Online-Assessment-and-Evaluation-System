package com.iiitb.evaluationBackend.user;

import org.springframework.data.repository.CrudRepository;

import com.iiitb.evaluationBackend.user.EvUser;

public interface UserRepository extends CrudRepository<EvUser, Integer> {
	
	public EvUser findByUserNameAndPassword(String userName, String password);

}
