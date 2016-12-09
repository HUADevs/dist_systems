package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaDevelopers.data.Entities.Vehicle;

public class VehicleDAOimpl implements VehicleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleDAOimpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addVehicle(Vehicle v) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(v);
		logger.info("Vehicle successfully inserted in database!!!" + v.toString());	
	}

	@Override
	public void updateVehicle(Vehicle v) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(v);
		logger.info("Vehicle successfully updated in database!!!" + v.toString());		
	}

	@Override
	public Vehicle getVehicleByPID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Vehicle v = session.load(Vehicle.class, new Integer(id));
		logger.info("Vehicle successfully selected from db" + v.toString());
		return v;
	}

	@Override
	public Vehicle getVehicleByLP(String lp) {
		Session session = this.sessionFactory.getCurrentSession();
		Vehicle v = session.load(Vehicle.class, new String(lp));
		logger.info("Vehicle successfully selected from db" + v.toString());
		return v;
	}

	@Override
	public List<Vehicle> listAllVehicles() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Vehicle> VList = session.createQuery("from Vehicle").getResultList();
		return VList;
	}

	@Override
	public void removeVehicle(String lp) {
		Session session = this.sessionFactory.getCurrentSession();
		Vehicle v = session.load(Vehicle.class, new String(lp));
		if (v != null) {
			session.delete(v);
			logger.info("Vehicle has successfully deleted from db" + v.toString());
		} else logger.info("Something went completely wrong");

		
	}

}
