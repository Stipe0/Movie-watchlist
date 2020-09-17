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
import com.watchlist.frontend.model.LoggedUser;

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
		ResponseEntity<Map> a= restTemplate.exchange("http://localhost:8081/myratedmovies", HttpMethod.POST,null ,Map.class);
		System.out.println(a.getBody());
		model.addAttribute("ratedmovies", a.getBody());
		return "MyRatedMovies";
	}
	
	
	
	@GetMapping("/ratemovie")
	public String rateMovie(Principal principal, Model model) {
		String currentUser = principal.getName();
		model.addAttribute("loggedUser", currentUser);
		return "RateUserMovie";
	}

	@PostMapping("/curretnuser")
	@ResponseBody
	public int currentUserName() {
		System.out.println("this one" + LoggedUser.getLoggedUserId());
		return LoggedUser.getLoggedUserId();

	}
	
	
	@GetMapping("/watchlist")
	public String watchlist(Model model) {
		Watchlist a = restTemplate.getForObject("http://localhost:8081/all", Watchlist.class);
		model.addAttribute("message", a);
		return "watchlist";// to string make it prettier
	}
	@GetMapping("/ratedmovies")
	public String getRatedMovies(Model model) {
		ResponseEntity<Map> a= restTemplate.exchange("http://localhost:8081/ratedmovies", HttpMethod.POST,null ,Map.class);
		System.out.println( a.getBody()+"getbody frint");
		model.addAttribute("ratedmovies", a.getBody());
		return "RatedMovies";
	}

}
