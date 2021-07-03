package com.ouym.restaurantmanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
		
	@Autowired
	LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	AuthFailureHandler authFailureHandler;
	
	@Autowired
	LogoutSuccessHandler logoutSuccessHandler;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/*user*", "/*User*").hasAuthority("ADMIN")
			.antMatchers("/new*", "/add*", "/all*").hasAuthority("MANAGER")
			.antMatchers("/getDropdowns", "/*order*", "/*Order*", "/*Bill*", "/*bill*").hasAnyAuthority("MANAGER", "ATTENDANT")
			.antMatchers("/edit*", "/update*", "/delete*").hasAuthority("MANAGER")
			.antMatchers("/").permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(loginSuccessHandler)
			.failureHandler(authFailureHandler)
			.and()
			.logout()
			.permitAll()
			.logoutSuccessHandler(logoutSuccessHandler)
			.and()
			.exceptionHandling().accessDeniedPage("/accessdenied");
	}
	
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
}
