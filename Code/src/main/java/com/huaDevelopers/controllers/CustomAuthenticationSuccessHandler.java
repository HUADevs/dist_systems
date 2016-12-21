package com.huaDevelopers.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
// Handler that redirects the user to the appropriate page based on his role
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	ServletContext context;

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		/* Redirect on the successful authentication of the user */
		logger.info("Hit the AuthSuccessHandler");
		String auths = authentication.getAuthorities().toString();
		if (auths.contains("Admin")) {
			response.sendRedirect(response.encodeURL(context.getContextPath()+"/admin/home"));
		} else if (auths.contains("User")) {
			response.sendRedirect(context.getContextPath());
		} else {
			response.sendRedirect(context.getContextPath()+"/cms/home");
		}

	}

}
