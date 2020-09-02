package com.watchlist.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.watchlist.backend.model.Watchlist;
import com.watchlist.backend.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping("/all")
	public Watchlist getAllMovies() {
		return new Watchlist(service.showAll());
	}



}
