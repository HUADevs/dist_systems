package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaDevelopers.data.Entities.User;

public class UserDAOimpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOimpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User usr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(usr);
		logger.info("User successfully inserted in database!!!" + usr.toString());		
	}

	@Override
	public void updateUser(User usr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(usr);
		logger.info("User successfully updated in database!!!" + usr.toString());		
	}

	@Override
	public User getUserByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		User usr = session.load(User.class, new String(username));
		logger.info("User successfully selected from db" + usr.toString());
		return usr;
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		User usr = session.load(User.class, new String(email));
		logger.info("User successfully selected from db" + usr.toString());
		return usr;
	}

	@Override
	public List<User> listAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> UsrList = session.createQuery("from User").getResultList();
		return UsrList;
	}

	@Override
	public void removeUser(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		User usr = session.load(User.class, new String(username));
		if (usr != null) {
			session.delete(usr);
			logger.info("User has successfully deleted from db" + usr.toString());
		} else logger.info("Something went completely wrong");		
	}

}