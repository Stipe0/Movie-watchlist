package com.watchlist.frontend.model;

import java.util.List;

public class Watchlist {

	private List<Movie> watchlist;

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for (Movie movie : watchlist) {
			sb.append(movie);
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();	
	}
		

	public Watchlist() {
		super();
	}

	public Watchlist(List<Movie> watchlist) {
		super();
		this.watchlist = watchlist;
	}

	public List<Movie> getWatchlist() {
		return watchlist;
	}

	public void setWatchlist(List<Movie> watchlist) {
		this.watchlist = watchlist;
	}

}
