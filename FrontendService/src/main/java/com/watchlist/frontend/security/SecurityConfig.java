package com.watchlist.frontend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
//
//	@Autowired
//	private DataSource dataSource;

	
	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	LoginSucessHandler successHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService );
		//.dataSource(dataSource)

//		.withUser(User.withUsername("stipe")
//				.password("stipe")
//				.roles("ADMIN"))
//		.withUser(User.withUsername("jurica")
//				.password("jurica")
//				.roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/registration").permitAll()
		//.antMatchers("/").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("USER")
//		.antMatchers("/movie").hasRole("ADMIN")
//		.antMatchers("/watchlist").hasAnyRole("USER","ADMIN")
		.and().formLogin()
		.successHandler(successHandler);
		//.permitAll().loginPage("/login");
		
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/admin/curretnuser")
	    .antMatchers("/user/curretnuser");
	}
	
	
	
	

}
