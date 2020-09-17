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
//
//	@Autowired
//	UserRepository userRepository;
//	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username);
		ResponseEntity<User> user = restTemplate.exchange("http://localhost:8081/user/" + username, HttpMethod.POST,
				null, User.class, username);
		//System.out.println("after rest and before user get body"+ "  "+user);
		User a = user.getBody();
		if (a == null)
			throw new UsernameNotFoundException(username + " not found");
		
//		User b= new User();
//		b.setUsername("as");
//		b.setPassword("as");
		MyUserDetails userDetails = new MyUserDetails(a);
		LoggedUser loggedUser= new LoggedUser(a);
		return userDetails;

//		UserDetails user= (UserDetails) restTemplate.exchange("http://localhost:8081/user/{username}", 
//				 HttpMethod.GET,
//				null,
//				UserDetails.class,
//				username);
//		return user;

//	      

		// Optional<User> user = userRepository.findByUsername(username);
//
//	        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
//
//	        return user.map(MyUserDetails::new).get();
//	    
	}
}
