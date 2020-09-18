package com.watchlist.frontend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.core.user.model.role.Role;
import com.core.user.model.user.User;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("")
	public String adminPage() {
		return "admin";
	}

	@GetMapping("/role")
	public String role() {
		return "RoleRegistration";
	}

	@GetMapping("/roleuserupdate")
	public String updateUserRole() {
		return "UpdateUserRole";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/userlist")
	public String userlist(Model model) {
		List<User> a = restTemplate.getForObject("http://localhost:8081/userlist", List.class);
		model.addAttribute("users", a);
		return "UserList";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/rolelist")
	public String rolelist(Model model) {
		List<Role> a = restTemplate.getForObject("http://localhost:8081/rolelist", List.class);
		model.addAttribute("roles", a);
		return "RoleList";
	}

	@GetMapping("/addmovie")
	public String addFilm() {
		return "newMovie";
	}

	@GetMapping("/ratemovie")
	public String rateMovie(Principal principal, Model model) {
		String currentUser = principal.getName();
		model.addAttribute("loggedUser", currentUser);
		return "RateMovie";
	}

}
