package com.iiitb.evaluationBackend.userRole;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRoleController {

	@Autowired
	public UserRoleService userRoleService;
	
	@RequestMapping("/user/{userId}/role/{roleId}/userRole")
	public List<EvUserRole> getUserRoleFromUserAndRoleIds(@PathVariable int userId, @PathVariable int roleId){
		return userRoleService.getUserRoleFromUserAndRoleIds(userId, roleId);
	}
	
	@RequestMapping("/username/{userName}/password/{password}/userRole")
	public EvUserRole getUserRoleFromUsernameAndPassword(@PathVariable String userName, @PathVariable String password){
		List<EvUserRole> userRoles = userRoleService.getUserRoleFromUsernameAndPassword(userName, password);
		if(userRoles == null) {
			return null;
		}
		return userRoles.get(0);
	}
}

