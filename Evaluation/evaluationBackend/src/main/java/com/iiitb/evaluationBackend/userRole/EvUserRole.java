package com.iiitb.evaluationBackend.userRole;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.iiitb.evaluationBackend.roleMaster.EvRoleMaster;
import com.iiitb.evaluationBackend.user.EvUser;
import com.iiitb.evaluationBackend.userRole.UserRoleKey;

@Entity
public class EvUserRole {
	
	@EmbeddedId
    private UserRoleKey userRoleId;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private EvUser user;
 
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private EvRoleMaster role;
    
    public EvUserRole() {
    	
    }

	public EvUserRole(UserRoleKey userRoleId, EvUser user, EvRoleMaster role) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	public UserRoleKey getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(UserRoleKey userRoleId) {
		this.userRoleId = userRoleId;
	}

	public EvUser getUser() {
		return user;
	}

	public void setUser(EvUser user) {
		this.user = user;
	}

	public EvRoleMaster getRole() {
		return role;
	}

	public void setRole(EvRoleMaster role) {
		this.role = role;
	}
    
    
    
}
