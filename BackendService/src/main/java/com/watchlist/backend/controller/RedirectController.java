package com.watchlist.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

public class RedirectController {

	private static final String LOGGED_USER_URL = "http://localhost:8082/logged/curretnuser";

	private static final String USER_HOME_PAGE = "redirect:http://localhost:8082/user";

	private static final String INDEX_PAGE = "redirect:http://localhost:8082/";

	private static final String ADMIN_HOME_PAGE = "redirect:http://localhost:8082/admin/";

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
		return ADMIN_HOME_PAGE;

	}

	@PostMapping("/registration")
	public String register(@ModelAttribute User user) {
		userService.saveUser(user);
		return INDEX_PAGE;
	}

	@PostMapping("/roleregistration")
	public String roleRegistration(@ModelAttribute("role") Role role) {
		roleService.saveRole(role);
		return ADMIN_HOME_PAGE;
	}

	@PostMapping("/roleuserupdate")
	public String roleUserUpdate(@RequestParam(name = "userID") int userID, @RequestParam(name = "roleID") int roleID) {
		User userWithID = userService.userByID(userID);
		Role roleWithID = roleService.getRoleById(roleID);
		if (userWithID != null && roleWithID != null)
			userService.updateUserRole(userWithID, roleWithID);
		return ADMIN_HOME_PAGE;
	}

	@PostMapping("/ratemovie")
	public String rateMovie(@RequestParam(name = "movieID") long movieID, @ModelAttribute Review review) {

		rateMovieMethod(movieID, review);

		return ADMIN_HOME_PAGE;
	}

	@PostMapping("/rateusermovie")
	public String rateMovieUser(@RequestParam(name = "movieID") long movieID, @ModelAttribute Review review) {

		rateMovieMethod(movieID, review);

		return USER_HOME_PAGE;
	}

	private void rateMovieMethod(long movieID, Review review) {
		if (review != null) {
			review.setMovieID(movieID);
			ResponseEntity<Integer> userID = restTemplate.exchange(LOGGED_USER_URL, HttpMethod.POST, null,
					Integer.class);
			if (userID.getBody() != null) {
				review.setUserID(userID.getBody());
				reviewService.saveReview(review);
			}
		}
	}

}
