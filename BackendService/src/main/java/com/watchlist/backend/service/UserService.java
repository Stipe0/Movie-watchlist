package com.watchlist.backend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watchlist.backend.model.Role;
import com.watchlist.backend.model.User;
import com.watchlist.backend.repostitory.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	RoleService roleService;

	public void saveUser(User user) {
		Role userRole = roleService.getRoleById(1);
		Set<Role> defaultRole = new HashSet<>();
		defaultRole.add(userRole);
		user.setRoles(defaultRole);
		repo.save(user);
	}

	public User retUser(String username) {
		Optional<User> user = repo.findByUsername(username);

		return user.orElse(null);
	}
	
	public User userByID(int id) {
		Optional<User> found=repo.findById(id);
	return found.orElse(null);
	}
	
	public void  updateUserRole(User user,Role role) {
		user.getRoles().add(role);
		repo.save(user);
	}
	
	public List<User> allUsers(){
		return repo.findAll();
	}
	
	public User userByUsername(String Username) {
		return repo.findByUsername(Username).orElse(null);
	}

}
