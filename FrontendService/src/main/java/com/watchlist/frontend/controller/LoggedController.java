package com.watchlist.frontend.controller;

import java.util.List;
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

import com.core.user.model.movie.Movie;
import com.watchlist.frontend.model.LoggedUser;

@Controller
@RequestMapping("/logged")
public class LoggedController {

	private static final String BACKEND_ALL_MOVIES = "http://localhost:8081/all";
	private static final String BACKEND_GET_RATED_MOVIES = "http://localhost:8081/ratedmovies";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/watchlist")
	public String watchlist(Model model) {
		@SuppressWarnings("unchecked")
		List<Movie> a = restTemplate.getForObject(BACKEND_ALL_MOVIES, List.class);
		model.addAttribute("message", a);
		return "watchlist";
	}

	@PostMapping("/curretnuser")
	@ResponseBody
	public int currentUserName() {
		return LoggedUser.getLoggedUserId();

	}

	@GetMapping("/ratedmovies")
	public String getRatedMovies(Model model) {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> a = restTemplate.exchange(BACKEND_GET_RATED_MOVIES, HttpMethod.POST, null, Map.class);
		model.addAttribute("ratedmovies", a.getBody());
		return "RatedMovies";
	}

}
