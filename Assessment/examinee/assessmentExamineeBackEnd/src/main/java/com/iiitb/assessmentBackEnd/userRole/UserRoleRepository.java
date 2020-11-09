package com.iiitb.assessmentBackEnd.userRole;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<AsUserRole, Integer> {

	public List<AsUserRole> findByUserRoleId(UserRoleKey userRoleId);
	public List<AsUserRole> findByUserUserId(int userId);
}
