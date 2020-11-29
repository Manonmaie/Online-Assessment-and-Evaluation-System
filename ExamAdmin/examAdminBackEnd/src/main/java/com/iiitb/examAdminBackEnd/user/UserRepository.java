package com.iiitb.examAdminBackEnd.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByUserName(String userName);
}
