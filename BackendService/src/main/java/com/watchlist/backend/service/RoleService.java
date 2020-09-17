package com.watchlist.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watchlist.backend.model.Role;
import com.watchlist.backend.repostitory.RoleRepositrory;

@Service
public class RoleService {
	@Autowired
	RoleRepositrory repo;
	
	public void saveRole(Role role) {
		repo.save(role);
	}
	
	public Role getRoleById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Role> getAllRolles(){
		return repo.findAll();
	}
}
