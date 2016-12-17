package com.huaDevelopers.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		/* Redirect on the successful authentication of the user */
		logger.info("Hit the AuthSuccessHandler");
		String auths = authentication.getAuthorities().toString();
		if (auths.contains("Admin")) {
			response.sendRedirect(response.encodeURL("/admin"));
		} else if (auths.contains("User")) {
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/cms");
		}

	}

}
