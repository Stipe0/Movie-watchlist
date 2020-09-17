package com.watchlist.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watchlist.backend.model.Movie;
import com.watchlist.backend.model.Review;
import com.watchlist.backend.repostitory.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository repo;
	
	@Autowired
	MovieService movieService;

	public void saveReview(Review review) {
		repo.save(review);
	}

	public List<Review> findAllReviews() {
		return repo.findAll();
	}

	public Map<Movie, Double> getReviewsForMovies(List<Movie> movies) {

		Map<Movie, Double> movieRew = new HashMap<>();
		List<Review> allReviews = this.findAllReviews();

		for (Movie movie : movies) {
			double avg;
			OptionalDouble avgRating = allReviews.stream().filter(review -> review.getMovieID() == movie.getId())
					.mapToInt(review -> review.getRating()).average();
			if (avgRating.isPresent()) {
				avg = (Math.round(avgRating.getAsDouble() * 100.0) / 100.0);
				if (avg > 0.0)
					movieRew.put(movie, avg);
			}

		}
		return movieRew;

	}
	
	
	public Map<Movie, Review> getMyReview(int userID){
		List<Review> myReview =repo.findAllByUserID(userID);
		if(myReview.isEmpty()) return null;
		
		System.out.println(myReview+"in rew serv");
		Map<Movie, Review> movRewMap= new HashMap<>();
		
		for (Review review : myReview) {
			movRewMap.put(movieService.findMovieByID(review.getMovieID()), review);
			
		}
		
		return movRewMap;
	}
}
