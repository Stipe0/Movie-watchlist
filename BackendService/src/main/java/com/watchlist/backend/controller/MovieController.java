package com.watchlist.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.model.RatedMovies;
import com.watchlist.backend.model.Review;
import com.watchlist.backend.model.Role;
import com.watchlist.backend.model.RoleList;
import com.watchlist.backend.model.User;
import com.watchlist.backend.model.UserList;
import com.watchlist.backend.model.Watchlist;
import com.watchlist.backend.service.MovieService;
import com.watchlist.backend.service.ReviewService;
import com.watchlist.backend.service.RoleService;
import com.watchlist.backend.service.UserService;

@RestController
public class MovieController {

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
	public Watchlist getAllMovies() {
		return new Watchlist(service.showAll());
	}
	
	@GetMapping("/userlist")
	public UserList getAllUsers() {
		return new UserList(userService.allUsers());
	}
	@GetMapping("/rolelist")
	public RoleList getAllRoles() {
		return new RoleList(roleService.getAllRolles());
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
	public RatedMovies getRatedMovies() {
		System.out.println("fine in backedn");
		List<Movie> movieList= service.findAllMovies();
		System.out.println("fine in backedn 2");
		RatedMovies rated= new RatedMovies(reviewService.getReviewsForMovies(movieList));
		System.out.println(rated);
		return rated;
		
	}
	
	@PostMapping("/myratedmovies")
	public Map<Movie, Review> getMyRatedMovies() {
		
		ResponseEntity<Integer> userID = restTemplate.exchange("http://localhost:8082/user/curretnuser",
				HttpMethod.POST, null, Integer.class);
		Map<Movie, Review> map= reviewService.getMyReview(userID.getBody());
		
		System.out.println(map);
		
		return map;
		
		
	}


}
