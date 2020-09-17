package com.watchlist.backend.model;

import java.io.Serializable;

public class ReviewID implements Serializable{
	
	private long movieID;
	private int userID;
	
	public ReviewID(long movieID, int userID) {
		super();
		this.movieID = movieID;
		this.userID = userID;
	}

	public ReviewID() {
		super();
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (movieID ^ (movieID >>> 32));
		result = prime * result + userID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewID other = (ReviewID) obj;
		if (movieID != other.movieID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
	

}
