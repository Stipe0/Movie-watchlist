package com.watchlist.frontend.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("")
	public String userPage() {
		return "user";
	}

	@GetMapping("/myratedmovies")
	public String myRatedMovies(Model model) {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> a = restTemplate.exchange("http://localhost:8081/myratedmovies", HttpMethod.POST, null,
				Map.class);
		model.addAttribute("ratedmovies", a.getBody());
		return "MyRatedMovies";
	}

	@GetMapping("/ratemovie")
	public String rateMovie(Principal principal, Model model) {
		String currentUser = principal.getName();
		model.addAttribute("loggedUser", currentUser);
		return "RateUserMovie";
	}

}
