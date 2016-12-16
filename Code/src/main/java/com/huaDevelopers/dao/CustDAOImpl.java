package com.huaDevelopers.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.huaDevelopers.dao.Interfaces.CustomerDAO;
import com.huaDevelopers.data.Entities.Customer;

@Repository
public class CustDAOImpl implements CustomerDAO {

	private static final Logger logger = LoggerFactory.getLogger(CustDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCustomer(Customer cust) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cust);
		logger.info("Customer successfully inserted in database!!!" + cust.toString());
	}

	@Override
	public void updateCustomer(Customer cust) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cust);
		logger.info("Customer successfully updated in database!!!" + cust.toString());
	}

	@Override
	public Customer getCustomerByID(String personalId) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer cust;
		try {
			cust = (Customer) session.createQuery("from Customer where personal_id='" + personalId + "'")
					.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		logger.info("Customer successfully selected from db" + cust.toString());
		return cust;
	}

	@Override
	public List<Customer> listAllCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Customer> CustList = session.createQuery("from Customer").getResultList();
		return CustList;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer cust = session.load(Customer.class, new Integer(id));
		if (cust != null) {
			session.delete(cust);
			logger.info("Customer has successfully deleted from db" + cust.toString());
		} else
			logger.info("Something went completely wrong");
	}

}
