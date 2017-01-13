package com.huaDevelopers.dao.Interfaces;

import java.util.List;

import com.huaDevelopers.data.Entities.User;

public interface UserDAO {

	public void addUser(User usr);

	public void updateUser(User usr);

	public User getUserByUsername(String username);

	public User getUserByEmail(String email);

	public User getUserById(Long id);

	public List<User> listAllUser();

	public void removeUser(Long userId);

}
