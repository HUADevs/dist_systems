package com.huaDevelopers.data.Services;

public interface SecurityService {

	public String findLoggedInUsername();

	public void autologin(String username, String password);

}
