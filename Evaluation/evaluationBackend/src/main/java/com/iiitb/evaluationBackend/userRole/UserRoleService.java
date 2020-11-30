package com.iiitb.evaluationBackend.userRole;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.evaluationBackend.roleMaster.EvRoleMaster;
import com.iiitb.evaluationBackend.user.EvUser;
import com.iiitb.evaluationBackend.user.UserRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<EvUserRole> getUserRoleFromUserAndRoleIds(int userId, int roleId) {
		UserRoleKey userRoleKey = new UserRoleKey(userId, roleId); 
		return userRoleRepository.findByUserRoleId(userRoleKey);
	}
	
	public EvRoleMaster getAllRolesForUserId(int userId){
		List<EvUserRole> userRoles = userRoleRepository.findByUserUserId(userId);
		if(userRoles.isEmpty()) {
			return null;
		}
		return userRoles.get(0).getRole();
	}
	
	public List<EvUserRole> getUserRoleFromUsernameAndPassword(String userName, String password) {
		EvUser user = userRepository.findByUserNameAndPassword(userName, password);
//		System.out.println("user = " + user);
		if(user == null) {
			return null;
		}
		EvRoleMaster role = getAllRolesForUserId(user.getUserId());
		if(role == null) {
			return null;
		}
		UserRoleKey userRoleKey = new UserRoleKey(user.getUserId(), role.getRoleId()); 
		return userRoleRepository.findByUserRoleId(userRoleKey);
	}
	
}

