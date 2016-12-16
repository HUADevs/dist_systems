package com.huaDevelopers.data.Services.Interfaces;

public interface SecurityService {

	public String findLoggedInUsername();

	public void autologin(String username, String password);

}
