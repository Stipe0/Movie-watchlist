package com.watchlist.frontend.model;

import java.util.List;

public class Watchlist {
	
	private List<Movie> watchlist;
	

	@Override
	public String toString() {
		return "Watchlist [watchlist=" + watchlist + "]";
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
