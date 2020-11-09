package com.iiitb.assessmentBackEnd.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AsUser, Integer> {
	
	public AsUser findByUserNameAndPassword(String userName, String password);

}
