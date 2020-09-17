package com.core.user.model.review.ratedmovies;

import java.util.Map;

import com.core.user.model.movie.Movie;

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
