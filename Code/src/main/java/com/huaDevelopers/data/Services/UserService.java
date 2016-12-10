package com.huaDevelopers.data.Services;

import java.util.List;

import com.huaDevelopers.data.Entities.User;

public interface UserService {
	
	public void addUser (User usr);

	public void updateUser (User usr);

	public User getUserByUsername(String username);
	
	public User getUserByEmail(String email);
	
	public List<User> listAllUser();

	public void removeUser(String username);
}