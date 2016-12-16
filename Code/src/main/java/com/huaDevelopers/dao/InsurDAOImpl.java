package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.dao.Interfaces.InsuranceDAO;
import com.huaDevelopers.data.Entities.Insurance;

@Repository
public class InsurDAOImpl implements InsuranceDAO {

	private static final Logger logger = LoggerFactory.getLogger(InsurDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addInsurance(Insurance insurance) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(insurance);
		logger.info("Insurance successfully inserted in database!!!" + insurance.toString());

	}

	@Override
	public void updateInsurance(Insurance insurance) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(insurance);
		logger.info("Insurance successfully updated in database!!!" + insurance.toString());
	}

	@Override
	public Insurance getInsuranceByLicensePlate(String licensePlate) {
		Session session = this.sessionFactory.getCurrentSession();
		Insurance insurance = (Insurance)session.createQuery("from Insurance where vehicle_id='"+licensePlate+"'").getSingleResult();
		logger.info("Insurance successfully selected from db" + insurance.toString());
		return insurance;
	}

	@Override
	public List<Insurance> listAllInsurances() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Insurance> InsurList = session.createQuery("from Insurance").getResultList();
		return InsurList;
	}

	@Override
	public void removeInsurance(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Insurance insurance = session.load(Insurance.class, new Integer(id));
		if (insurance != null) {
			session.delete(insurance);
			logger.info("Insurance has successfully deleted from db" + insurance.toString());
		} else
			logger.info("Something went completely wrong");

	}

	@Override
	public Insurance getInsuranceByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Insurance insurance= session.load(Insurance.class, new Integer(id));
		logger.info("Insurance successfully selected from db" + insurance.toString());
		return insurance;
	}

}
