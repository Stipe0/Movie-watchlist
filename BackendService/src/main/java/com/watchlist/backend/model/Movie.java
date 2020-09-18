package com.watchlist.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private Long Id;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private int year;

	@Column(name = "genre")
	private String genre;

	@Column(name = "summary")
	private String summary;


	public Movie(Long id, String title, int year, String genre, String summary) {
		super();
		Id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.summary = summary;
	}

	public Movie() {
		super();
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", title=" + title + ", year=" + year + ", genre=" + genre + ", summary=" + summary
				+ "]\n";
	}

}
