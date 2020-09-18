package com.watchlist.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.model.Review;
import com.watchlist.backend.model.Role;
import com.watchlist.backend.model.User;
import com.watchlist.backend.service.MovieService;
import com.watchlist.backend.service.ReviewService;
import com.watchlist.backend.service.RoleService;
import com.watchlist.backend.service.UserService;

@RestController
public class RestSourceController {

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

	@GetMapping("/all")
	public List<Movie> getAllMovies() {
		return service.showAll();
	}

	@GetMapping("/userlist")
	public List<User> getAllUsers() {
		return userService.allUsers();
	}

	@GetMapping("/rolelist")
	public List<Role> getAllRoles() {
		return roleService.getAllRolles();
	}

	@PostMapping("/user/{username}")
	public User authenticate(@PathVariable String username) {
		return userService.retUser(username);
	}

	@PostMapping("/role/{id}")
	public Role authenticate(@PathVariable int id) {
		return roleService.getRoleById(id);
	}

	@PostMapping("/ratedmovies")
	public Map<Movie, Double> getRatedMovies() {
		List<Movie> movieList = service.findAllMovies();
		Map<Movie, Double> rated = reviewService.getReviewsForMovies(movieList);
		return rated;

	}

	@PostMapping("/myratedmovies")
	public Map<Movie, Review> getMyRatedMovies() {

		ResponseEntity<Integer> userID = restTemplate.exchange("http://localhost:8082/user/curretnuser",
				HttpMethod.POST, null, Integer.class);
		Map<Movie, Review> map = reviewService.getMyReview(userID.getBody());

		return map;

	}

}
