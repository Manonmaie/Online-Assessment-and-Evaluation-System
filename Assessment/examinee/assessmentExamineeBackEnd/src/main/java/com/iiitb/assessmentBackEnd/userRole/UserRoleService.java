package com.iiitb.assessmentBackEnd.userRole;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiitb.assessmentBackEnd.roleMaster.AsRoleMaster;
import com.iiitb.assessmentBackEnd.user.AsUser;
import com.iiitb.assessmentBackEnd.user.UserRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<AsUserRole> getUserRoleFromUserAndRoleIds(int userId, int roleId) {
		UserRoleKey userRoleKey = new UserRoleKey(userId, roleId); 
		return userRoleRepository.findByUserRoleId(userRoleKey);
	}
	
	public AsRoleMaster getAllRolesForUserId(int userId){
		List<AsUserRole> userRoles = userRoleRepository.findByUserUserId(userId);
		if(userRoles.isEmpty()) {
			return null;
		}
		return userRoles.get(0).getRole();
	}
	
	public List<AsUserRole> getUserRoleFromUsernameAndPassword(String userName, String password) {
		AsUser user = userRepository.findByUserNameAndPassword(userName, password);
//		System.out.println("user = " + user);
		if(user == null) {
			return null;
		}
		AsRoleMaster role = getAllRolesForUserId(user.getUserId());
		if(role == null) {
			return null;
		}
		UserRoleKey userRoleKey = new UserRoleKey(user.getUserId(), role.getRoleId()); 
		return userRoleRepository.findByUserRoleId(userRoleKey);
	}
	
}
