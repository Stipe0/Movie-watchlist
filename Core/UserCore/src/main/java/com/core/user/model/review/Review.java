package com.core.user.model.review;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.user.model.movie.Movie;

@Entity
@Table(name = "Review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int id;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "comment")
	private String comment;

	@ManyToMany
	@JoinTable(name = "review_movie", joinColumns = @JoinColumn(name = "review_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> movies;

	public Review(int id, int rating, String comment, Set<Movie> movies) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.movies = movies;
	}

	public Review() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", comment=" + comment + ", movies=" + movies + "]";
	}
	
	
}
