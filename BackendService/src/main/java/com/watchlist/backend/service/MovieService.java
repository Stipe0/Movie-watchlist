package com.watchlist.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.repostitory.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;

	public List<Movie> showAll() {
		return repo.findAll();
	}

	public void newMovie(Movie movie) {
		repo.save(movie);
	}
		
}
