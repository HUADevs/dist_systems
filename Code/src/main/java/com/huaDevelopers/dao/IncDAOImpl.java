package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.dao.Interfaces.IncDAO;
import com.huaDevelopers.data.Entities.History;

@Repository
public class IncDAOImpl implements IncDAO {

	private static final Logger logger = LoggerFactory.getLogger(IncDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addIncident(History hr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(hr);
		logger.info("History Incident has successfully inserted in db" + hr.toString());
	}

	@Override
	public void updateIncident(History hr) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hr);
		logger.info("History Incident has successfully updated " + hr.toString());

	}

	@Override
	public History getIncidentByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		History hr = session.load(History.class, new Integer(id));
		logger.info("History incident has obtained from db" + hr.toString());
		return hr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> listAllIncidents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<History> list = session.createQuery("from History").getResultList();
		logger.info("Listing all incidents was a success" + list.toString());
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> listAllIncsPerCustomer(String CustId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<History> Custlist = session.createQuery("from History where personal_id='" + CustId + "'").getResultList();
		return Custlist;
	}

	@Override
	public void removeIncident(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		History hr = session.load(History.class, new Integer(id));
		if (hr != null) {
			session.delete(hr);
			logger.info("Incident has successfully deleted from db" + hr.toString());
		} else
			logger.info("Something went completely wrong");
	}

}
