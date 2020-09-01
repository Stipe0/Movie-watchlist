package com.watchlist.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.model.Watchlist;
import com.watchlist.backend.service.MovieService;

@RestController
public class MovieController {
	
	
	@Autowired
	private MovieService service;
	
	
	@GetMapping("/all")
	public Watchlist getAllMovies(){
		return new Watchlist(service.showAll()) ;
	}
		
		
//	@GetMapping("/all")
//	public String getAllMovies(){
//		return "readiii";
//	}
	
	@PostMapping("/movie")
	public String addMovie(@RequestBody Movie movie) {
		System.out.println("this is wxecuting");
		return service.newMovie(movie);
	}
	
	

}
