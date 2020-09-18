package com.watchlist.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.core.user.mode.movie.watchlist.Watchlist;

@Controller

public class WatchlistController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/registration")
	public String register() {
		return "Registration";
	}

//	@GetMapping("/watchlist")
//	public String watchlist(Model model) {
//		Watchlist a = restTemplate.getForObject("http://localhost:8081/all", Watchlist.class);
//		model.addAttribute("message",a);
//		return "watchlist";
//	}
	
	

}
