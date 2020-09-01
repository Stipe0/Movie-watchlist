package com.watchlist.backend.model;

import javax.persistence.*;


@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String title;
	private int year;
	private String genre;				// enum genre
	private int rating;
	
	public Movie() {
		super();
	}
	public Movie(String title, int year, String genre, int rating) {
		super();
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.rating = rating;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", title=" + title + ", year=" + year + ", genre=" + genre + ", rating=" + rating
				+ "]";
	}
	
	

	
}
