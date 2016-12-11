package com.huaDevelopers.data.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.UserDAO;
import com.huaDevelopers.data.Entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO usrDAO;
	
	public void setUsrDAO(UserDAO usrDAO) {
		this.usrDAO = usrDAO;
	}
	
	@Override
	@Transactional
	public void addUser(User usr) {
		this.usrDAO.addUser(usr);
	}

	@Override
	@Transactional
	public void updateUser(User usr) {
		this.usrDAO.updateUser(usr);
	}

	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return this.usrDAO.getUserByUsername(username);
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return this.usrDAO.getUserByEmail(email);
	}

	@Override
	@Transactional
	public List<User> listAllUser() {
		return this.usrDAO.listAllUser();
	}

	@Override
	@Transactional
	public void removeUser(String username) {
		this.usrDAO.removeUser(username);
	}

}
