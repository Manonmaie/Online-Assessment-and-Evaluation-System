package com.iiitb.assessmentBackEnd.userRole;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import com.iiitb.assessmentBackEnd.roleMaster.AsRoleMaster;
import com.iiitb.assessmentBackEnd.user.AsUser;


@Entity
public class AsUserRole {
	
	@EmbeddedId
    private UserRoleKey userRoleId;
	
	@ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private AsUser user;
 
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private AsRoleMaster role;

    public AsUserRole() {
    	
    }
    
	public AsUserRole(UserRoleKey userRoleKey, AsUser user, AsRoleMaster role) {
		super();
		this.userRoleId = userRoleKey;
		this.user = user;
		this.role = role;
	}

	public UserRoleKey getUserRoleKey() {
		return userRoleId;
	}

	public void setUserRoleKey(UserRoleKey userRoleKey) {
		this.userRoleId = userRoleKey;
	}

	public AsUser getUser() {
		return user;
	}

	public void setUser(AsUser user) {
		this.user = user;
	}

	public AsRoleMaster getRole() {
		return role;
	}

	public void setRole(AsRoleMaster role) {
		this.role = role;
	}
}
