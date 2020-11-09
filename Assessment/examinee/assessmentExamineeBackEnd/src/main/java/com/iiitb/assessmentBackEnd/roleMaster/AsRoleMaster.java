package com.iiitb.assessmentBackEnd.roleMaster;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iiitb.assessmentBackEnd.userRole.AsUserRole;

@Entity
public class AsRoleMaster {
	
	@Id
	private int roleId;
	private String roleName;
	private enum moduleNameList {AU, AS, EVAL, EA};
	private String moduleName;
	
	@OneToMany(mappedBy="role")
	@JsonIgnore
	private List<AsUserRole> asUserRoleList;
	
	public AsRoleMaster() {
		
	}
	
	public AsRoleMaster(int roleId, String roleName, String moduleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.moduleName = moduleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
}
