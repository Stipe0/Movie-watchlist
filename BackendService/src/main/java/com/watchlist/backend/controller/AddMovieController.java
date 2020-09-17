package com.watchlist.backend.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.model.Review;
import com.watchlist.backend.model.Role;
import com.watchlist.backend.model.User;
import com.watchlist.backend.service.MovieService;
import com.watchlist.backend.service.ReviewService;
import com.watchlist.backend.service.RoleService;
import com.watchlist.backend.service.UserService;

@Controller

public class AddMovieController {

	@Autowired
	private MovieService service;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/movie")
	public String addMovie(@ModelAttribute Movie movie) {
		service.newMovie(movie);
		return "redirect:http://localhost:8082/admin/";

	}

	@PostMapping("/registration")
	public String register(@ModelAttribute User user) {

		userService.saveUser(user);
		return "redirect:http://localhost:8082/";
	}

	@PostMapping("/roleuserupdate")
	public String roleUserUpdate(@RequestParam(name = "userID") int userID, @RequestParam(name = "roleID") int roleID) {
		User userWithID = userService.userByID(userID);
		Role roleWithID = roleService.getRoleById(roleID);
		// if user or role null exceprion
		userService.updateUserRole(userWithID, roleWithID);
		return "redirect:http://localhost:8082/admin";
	}

	@PostMapping("/roleregistration")
	public String roleRegistration(@ModelAttribute("role") Role role) {

		roleService.saveRole(role);
		return "redirect:http://localhost:8082/admin";
	}

	@PostMapping("/ratemovie")
	public String rateMovie(@RequestParam(name = "movieID") long movieID, @ModelAttribute Review review) {

		if (review != null) {
			review.setMovieID(movieID);
			ResponseEntity<Integer> userID = restTemplate.exchange("http://localhost:8082/admin/curretnuser",
					HttpMethod.POST, null, Integer.class);
			if(userID.getBody()!=null) {
			review.setUserID(userID.getBody());
			reviewService.saveReview(review);
			}
		}

		return "redirect:http://localhost:8082/admin";
	}
	@PostMapping("/rateusermovie")
	public String rateMovieUser(@RequestParam(name = "movieID") long movieID, @ModelAttribute Review review) {
		
		if (review != null) {
			review.setMovieID(movieID);
			ResponseEntity<Integer> userID = restTemplate.exchange("http://localhost:8082/user/curretnuser",
					HttpMethod.POST, null, Integer.class);
			if(userID.getBody()!=null) {
				review.setUserID(userID.getBody());
				reviewService.saveReview(review);
			}
		}
		
		return "redirect:http://localhost:8082/user";
	}

}
