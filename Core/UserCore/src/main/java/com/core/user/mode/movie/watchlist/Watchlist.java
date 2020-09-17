package com.core.user.mode.movie.watchlist;

import java.util.List;

import com.core.user.model.movie.Movie;

public class Watchlist {

	private List<Movie> watchlist;

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for (Movie movie : watchlist) {
			sb.append(movie);
			sb.append("/n");
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