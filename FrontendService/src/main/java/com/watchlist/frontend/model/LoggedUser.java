package com.watchlist.frontend.model;

import com.core.user.model.user.User;

public class LoggedUser {
	private static User user;

	public LoggedUser(User user) {
		LoggedUser.user = user;
	}

	public static String getUsername() {
		return user.getUsername();
	}

	public static int getLoggedUserId() {
		return user.getId();
	}

}
