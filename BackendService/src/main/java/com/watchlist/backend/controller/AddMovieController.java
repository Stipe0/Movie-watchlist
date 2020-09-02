package com.watchlist.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.service.MovieService;

@Controller

public class AddMovieController {

	@Autowired
	private MovieService service;
	
	
	@PostMapping("/movie")
	public String addMovie(@ModelAttribute Movie movie) {

		 service.newMovie(movie);
		 return "redirect:http://localhost:8082/watchlist";
		 
	}
}
