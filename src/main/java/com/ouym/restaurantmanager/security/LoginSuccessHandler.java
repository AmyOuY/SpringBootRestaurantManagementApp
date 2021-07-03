package com.ouym.restaurantmanager.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String redirectURL = "/";
		
		request.getSession().setAttribute("login", true);
		request.getSession().setAttribute("loginUser", authentication.getName());
		request.getSession().setAttribute("logout", false);
		
		response.sendRedirect(redirectURL); 
		
		
	}

	
}
