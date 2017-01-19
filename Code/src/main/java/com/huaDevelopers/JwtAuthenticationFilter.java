package com.huaDevelopers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huaDevelopers.data.Entities.User;
import com.huaDevelopers.data.Services.JwtService;

public class JwtAuthenticationFilter implements Filter {

	private  JwtService jwtService;
	
	public void setJwtService(JwtService jwtService){
		this.jwtService=jwtService;
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter initialized");
	}

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		//System.out.println("Requested Resource::" + uri);

		String token = req.getHeader("Token");

		System.out.println("--<<<->>>>---" + token);

		User u = new User();
		try {
			System.out.println("--<<<INSIDE TRY->>>>---");
			u = jwtService.parseToken(token);
			System.out.println("--<<<->>>>---" + u.getFirstName());
			if (u == null) {
				System.out.println("Unauthorized access request " + uri);
				res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			} else {
				// pass the request along the filter chain
				System.out.println("Authorized access request " + uri);
				chain.doFilter(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}

	}

	@Override
	public void destroy() {
		// close any resources here
	}

}