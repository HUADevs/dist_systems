package com.huaDevelopers.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.data.Entities.Role;
import com.huaDevelopers.data.Entities.Services;

@Repository
public class ServiceDAOimpl implements ServiceDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceDAOimpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addService(Services s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
		logger.info("Service successfully inserted in database!!!" + s.toString());	
	}

	@Override
	public void updateService(Services s) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
		logger.info("Service successfully updated in database!!!" + s.toString());		
	}

	@Override
	public Services getServiceByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Services s = session.load(Services.class, new Integer(id));
		logger.info("Service successfully selected from db" + s.toString());
		return s;
	
	}

	@Override
	public List<Services> listAllServices() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Services> SList = session.createQuery("from Services").getResultList();
		return SList;
	}

	@Override
	public void removeService(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Services s = session.load(Services.class, new Integer(id));
		if (s != null) {
			session.delete(s);
			logger.info("Service has successfully deleted from db" + s.toString());
		} else logger.info("Something went completely wrong");		
	}

	@Override
	public Set<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoles(Set<Role> roles) {
		//todo
	}

}
