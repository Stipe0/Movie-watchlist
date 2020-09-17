package com.watchlist.frontend.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.core.user.mode.movie.watchlist.Watchlist;
import com.core.user.model.role.rolelist.RoleList;
import com.core.user.model.user.userlist.UserList;
import com.watchlist.frontend.model.LoggedUser;

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

	@GetMapping("/userlist")
	public String userlist(Model model) {
		UserList a = restTemplate.getForObject("http://localhost:8081/userlist", UserList.class);
		model.addAttribute("users", a);
		return "UserList";
	}

	@GetMapping("/rolelist")
	public String rolelist(Model model) {
		RoleList a = restTemplate.getForObject("http://localhost:8081/rolelist", RoleList.class);
		model.addAttribute("roles", a);
		return "RoleList";
	}

	// overinde user and role to string
	@GetMapping("/addmovie")
	public String addFilm() {
		return "newMovie";
	}

	@GetMapping("/watchlist")
	public String watchlist(Model model) {
		Watchlist a = restTemplate.getForObject("http://localhost:8081/all", Watchlist.class);
		model.addAttribute("message", a);
		return "watchlist";// to string make it prettier
	}

	@GetMapping("/ratemovie")
	public String rateMovie(Principal principal, Model model) {
		String currentUser = principal.getName();
		model.addAttribute("loggedUser", currentUser);
		return "RateMovie";
	}

	@PostMapping("/curretnuser")
	@ResponseBody
	public int currentUserName() {
		System.out.println("this one" + LoggedUser.getLoggedUserId());
		return LoggedUser.getLoggedUserId();

	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/ratedmovies")
	public String getRatedMovies(Model model) {
		System.out.println("volimo sier");
		ResponseEntity<Map> a= restTemplate.exchange("http://localhost:8081/ratedmovies", HttpMethod.POST,null ,Map.class);
		System.out.println( a.getBody()+"getbody frint");
		model.addAttribute("ratedmovies", a.getBody());
		return "RatedMovies";
	}
	

}
