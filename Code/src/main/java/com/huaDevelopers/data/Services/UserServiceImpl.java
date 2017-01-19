package com.huaDevelopers.data.Services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.Interfaces.UserDAO;
import com.huaDevelopers.data.Entities.User;
import com.huaDevelopers.data.Services.Interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO usrDAO;
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

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
	public User getUserById(Long id) {
		return this.usrDAO.getUserById(id);
	}

	@Override
	@Transactional
	public List<User> listAllUser() {
		return this.usrDAO.listAllUser();
	}

	@Override
	@Transactional
	public void removeUser(Long userId) {
		this.usrDAO.removeUser(userId);
	}
	
	@Override
	public User login(String username, String password) {
		Boolean state=false;
		
		String query = "select * from User where username = ? and password = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		Object queryForObject = jdbcTemplate.queryForObject(query, new Object[] { username, password },
				new BeanPropertyRowMapper<User>(User.class));
		User user = (User) queryForObject;

		return user;
	}

}
