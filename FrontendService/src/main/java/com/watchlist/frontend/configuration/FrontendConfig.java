package com.watchlist.frontend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.watchlist.frontend.model.MyUserDetails;

@Configuration
public class FrontendConfig {
	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}
	
	

}
