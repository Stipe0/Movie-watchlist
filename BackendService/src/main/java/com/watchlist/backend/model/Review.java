package com.watchlist.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
@IdClass(ReviewID.class)
public class Review implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private long movieID;

	@Id
	private int userID;

	@Column(name = "rating")
	private int rating;

	@Column(name = "comment")
	private String comment;

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

	public long getMovieID() {
		return movieID;
	}

	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Review [rating=" + rating + ", comment=" + comment + "]\n";
	}
	
	

}
