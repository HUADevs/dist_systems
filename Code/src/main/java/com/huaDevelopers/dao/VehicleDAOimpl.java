package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.dao.Interfaces.VehicleDAO;
import com.huaDevelopers.data.Entities.Vehicle;

@Repository
public class VehicleDAOimpl implements VehicleDAO {

	private static final Logger logger = LoggerFactory.getLogger(VehicleDAOimpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addVehicle(Vehicle v) {
		System.out.println("inside addVehicle");
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
	public Vehicle getVehicleByPID(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Vehicle v = session.load(Vehicle.class, id);
		logger.info("Vehicle successfully selected from db" + v.toString());
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vehicle getVehicleByLP(String lp) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Vehicle> v = session.createQuery("FROM Vehicle where license_plate='" + lp + "'").getResultList();
		if (v.isEmpty())
			return null;
		logger.info("Vehicle successfully selected from db" + v.toString());
		return v.get(0);
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
		Vehicle v = (Vehicle) session.createQuery("FROM Vehicle where license_plate='" + lp + "'").getSingleResult();
		if (v != null) {
			session.delete(v);
			logger.info("Vehicle has successfully deleted from db" + v.toString());
		} else
			logger.info("Something went completely wrong");

	}

}
