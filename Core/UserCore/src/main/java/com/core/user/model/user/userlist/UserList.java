package com.core.user.model.user.userlist;

import java.util.List;

import com.core.user.model.user.User;

public class UserList {
	
	private List<User> users;
	

	public UserList() {
		super();
	}
	public UserList(List<User> users) {
		super();
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserList [users=" + users + "]";
	}
	
	

}