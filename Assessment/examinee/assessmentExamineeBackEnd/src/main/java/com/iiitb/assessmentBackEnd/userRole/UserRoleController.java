package com.iiitb.assessmentBackEnd.userRole;

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
	public List<AsUserRole> getUserRoleFromUserAndRoleIds(@PathVariable int userId, @PathVariable int roleId){
		return userRoleService.getUserRoleFromUserAndRoleIds(userId, roleId);
	}
	
	@RequestMapping("/username/{userName}/password/{password}/userRole")
	public AsUserRole getUserRoleFromUsernameAndPassword(@PathVariable String userName, @PathVariable String password){
		return userRoleService.getUserRoleFromUsernameAndPassword(userName, password).get(0);
	}
}
