package com.core.user.model.role.rolelist;

import java.util.List;

import com.core.user.model.role.Role;

public class RoleList {
	
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public RoleList(List<Role> roles) {
		super();
		this.roles = roles;
	}

	public RoleList() {
		super();
	}

	@Override
	public String toString() {
		return "RoleList [roles=" + roles + "]";
	}
	
}
