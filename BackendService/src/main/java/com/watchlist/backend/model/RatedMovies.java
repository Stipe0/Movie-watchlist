package com.watchlist.backend.model;

import java.util.Map;

public class RatedMovies {
	
	Map<Movie,Double> avgMovieRating;

	public Map<Movie, Double> getAvgMovieRating() {
		return avgMovieRating;
	}

	public void setAvgMovieRating(Map<Movie, Double> avgMovieRating) {
		this.avgMovieRating = avgMovieRating;
	}

	public RatedMovies(Map<Movie, Double> avgMovieRating) {
		super();
		this.avgMovieRating = avgMovieRating;
	}

	@Override
	public String toString() {
		return "RatedMovies [avgMovieRating=" + avgMovieRating + "]";
	}

	
	

}
