package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaDevelopers.data.Entities.Role;

public class RoleDAOImpl implements RoleDao {

	private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(role);
		logger.info("Role successfully inserted in database!!!" + role.toString());

	}

	@Override
	public void updateRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(role);
		logger.info("Role successfuly updated in database!!!"+ role.toString());

	}

	@Override
	public Role getRoleByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role role= session.load(Role.class, new Integer(id));
		logger.info("Role successfully selected from db" + role.toString());
		return role;
	}

	@Override
	public List<Role> listAllRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Role> RoleList = session.createQuery("from Role").getResultList();
		return RoleList;
	}

	@Override
	public void removeRole(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role role = session.load(Role.class, new Integer(id));
		if (role != null) {
			session.delete(role);
			logger.info("Role has successfully deleted from db" + role.toString());
		} else logger.info("Something went completely wrong");

	}

}
