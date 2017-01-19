package com.huaDevelopers.controllers.Rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huaDevelopers.data.Entities.User;
import com.huaDevelopers.data.Services.JwtService;
import com.huaDevelopers.data.Services.Interfaces.UserService;

@RestController
@RequestMapping(value = "/rest")
public class RestLoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	public RestLoginController() {
		this(null, null);
	}

	@Autowired
	public RestLoginController(UserService userService, JwtService jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletResponse response) {
		User user = new User();

		try {
			user = userService.login(username, password);
			response.setHeader("Token", jwtService.tokenFor(user));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return user;
	}

}
