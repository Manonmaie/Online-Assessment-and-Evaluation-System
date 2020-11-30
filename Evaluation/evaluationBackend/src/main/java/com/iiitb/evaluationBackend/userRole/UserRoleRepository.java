package com.iiitb.evaluationBackend.userRole;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<EvUserRole, Integer> {

	public List<EvUserRole> findByUserRoleId(UserRoleKey userRoleId);
	public List<EvUserRole> findByUserUserId(int userId);
}
