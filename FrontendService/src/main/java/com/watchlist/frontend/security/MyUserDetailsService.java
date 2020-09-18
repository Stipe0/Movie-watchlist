package com.watchlist.frontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.core.user.model.user.User;
import com.watchlist.frontend.model.LoggedUser;
import com.watchlist.frontend.model.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ResponseEntity<User> user = restTemplate.exchange("http://localhost:8081/user/" + username, HttpMethod.POST,
				null, User.class, username);
		User a = user.getBody();
		if (a == null)
			throw new UsernameNotFoundException(username + " not found");

		MyUserDetails userDetails = new MyUserDetails(a);
		@SuppressWarnings("unused")
		LoggedUser loggedUser = new LoggedUser(a);
		return userDetails;

	}
}
