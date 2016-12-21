package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.dao.Interfaces.DamFormDAO;
import com.huaDevelopers.data.Entities.DamageForm;

@Repository
public class DFormDAOImpl implements DamFormDAO {

	private static final Logger logger = LoggerFactory.getLogger(DFormDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addDamageForm(DamageForm dForm) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dForm);
		logger.info("Damage Form has been inserted into the db. " + dForm.toString());
	}

	@Override
	public void updateDamageForm(DamageForm dForm) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dForm);
		logger.info("Damage form has been upadted. " + dForm.toString());
	}

	@Override
	public void deleteDamageForm(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DamageForm dForm = session.load(DamageForm.class, new Integer(id));
		if (dForm != null) {
			session.delete(dForm);
			logger.info("DamageForm has successfully deleted from db" + dForm.toString());
		} else
			logger.info("Something went completely wrong");
	}

	@SuppressWarnings("unchecked")
	@Override
	// no security
	public List<DamageForm> listDamageFormsPerVehicle(String plate) {
		Session session = this.sessionFactory.getCurrentSession();
		List<DamageForm> Formlist = session.createQuery("from DamageForm where license_plate='" + plate + "'")
				.getResultList();
		return Formlist;
	}

	@Override
	public DamageForm getFormById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DamageForm df = session.load(DamageForm.class, new Integer(id));
		logger.info("Damage Form has obtained from db" + df.toString());
		return df;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DamageForm> listAllDamageForms() {
		Session session = this.sessionFactory.getCurrentSession();
		List<DamageForm> Formlist = session.createQuery("from DamageForm").getResultList();
		return Formlist;
	}

	@Override
	public Long getFormCount(String role) {
		Session session = this.sessionFactory.getCurrentSession();
		Long counter;
		if(role.equals("Sales Manager")){
			counter = (Long)session.createQuery("select count(*) from DamageForm where cost>=300 and cost<2000 and approval=NULL").getSingleResult();
		}else if(role.equals("CEO")){
			counter = (Long)session.createQuery("select count(*) from DamageForm where cost>=2000 and approval=NULL").getSingleResult();
		}else{
			counter = (Long)session.createQuery("select count(*) from DamageForm where cost<300 and approval=NULL").getSingleResult();
		}
		return counter;
	}
	

}
