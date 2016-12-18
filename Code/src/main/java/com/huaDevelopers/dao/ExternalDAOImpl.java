package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.dao.Interfaces.ExternalDAO;
import com.huaDevelopers.data.Entities.External.ExternalCitizen;
import com.huaDevelopers.data.Entities.External.ExternalHistory;
import com.huaDevelopers.data.Entities.External.ExternalVehicle;

@Repository
public class ExternalDAOImpl implements ExternalDAO {

	private static final Logger logger = LoggerFactory.getLogger(ExternalDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public ExternalCitizen getCitizen(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		ExternalCitizen newCustomer = (ExternalCitizen) session
				.createQuery("FROM ExternalCitizen where personalId='" + id + "'").getSingleResult();
		logger.info("Extract citizen from nationalDB with success " + newCustomer.toString());
		return newCustomer;
	}

	@Override
	public ExternalVehicle getVehicle(String lp) {
		Session session = this.sessionFactory.getCurrentSession();
		ExternalVehicle car = (ExternalVehicle) session.createQuery("FROM ExternalVehicle where license_plate='" + lp + "'")
				.getSingleResult();
		logger.info("Extract vehicle from nationalDB with success " + car.toString());
		return car;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExternalHistory> getHistoryList(String id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<ExternalHistory> incs = session.createQuery("FROM ExternalHistory where person_id='" + id + "'")
				.getResultList();
		logger.info("Extract list of incedents from nationalDB with success " + incs.toString());
		return incs;
	}
}
