package com.huaDevelopers.data.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaDevelopers.dao.CustomerDAO;
import com.huaDevelopers.dao.IncDAO;
import com.huaDevelopers.dao.InsuranceDAO;
import com.huaDevelopers.dao.VehicleDAO;
import com.huaDevelopers.data.Entities.Customer;
import com.huaDevelopers.data.Entities.History;
import com.huaDevelopers.data.Entities.Insurance;
import com.huaDevelopers.data.Entities.Vehicle;

@Service
public class InsurServiceImpl implements InsuranceService {

	private InsuranceDAO insurDAO;

	private CustomerDAO custDAO;

	private VehicleDAO vDAO;

	private IncDAO incDAO;

	private SessionFactory externalFactory;

	public void setExternalFactory(SessionFactory externalFactory) {
		this.externalFactory = externalFactory;
	}

	public void setInsurDAO(InsuranceDAO insurDAO) {
		this.insurDAO = insurDAO;
	}

	public void setCustDAO(CustomerDAO custDAO) {
		this.custDAO = custDAO;
	}

	public void setvDAO(VehicleDAO vDAO) {
		this.vDAO = vDAO;
	}

	public void setIncDAO(IncDAO incDAO) {
		this.incDAO = incDAO;
	}

	@Override
	@Transactional
	public void addInsurance(Insurance insurance) {
		this.insurDAO.addInsurance(insurance);
	}

	@Transactional
	@Override
	public void updateInsurance(Insurance insurance) {
		this.insurDAO.updateInsurance(insurance);
	}

	@Transactional
	@Override
	public Insurance getInsuranceByID(int id) {
		return this.insurDAO.getInsuranceByID(id);
	}

	@Transactional
	@Override
	public Insurance getInsuranceByLicensePlate(String licensePlate) {
		return this.insurDAO.getInsuranceByLicensePlate(licensePlate);
	}

	@Transactional
	@Override
	public List<Insurance> listAllInsurances() {
		return this.insurDAO.listAllInsurances();
	}

	@Transactional
	@Override
	public void removeInsurance(int id) {
		this.insurDAO.removeInsurance(id);
	}

	@Override
	@Transactional
	public float countInsCost(Vehicle vehicle, Customer cust) {
		float cost = 0;
		int cubic = vehicle.getCubic();
		if (cubic <= 1000)
			cost = 250;
		else if (cubic <= 1400)
			cost = 300;
		else if (cubic <= 1800)
			cost = 350;
		else
			cost = 450;
		float discount = countIncDiscount(cust);
		if (discount != 0)
			return cost * discount;
		return cost;
	}

	@Transactional
	public float countIncDiscount(Customer cust) {
		float discount = 0;
		int exp = howManyYears(cust);
		for (int i = exp; i >= 0; i -= 10) {
			if (exp >= 10)
				discount = discount + 10 / 100;
		}
		return discount;
	}

	@Transactional
	public int howManyYears(Customer cust) {
		LocalDateTime initialDate = cust.getLicenseAqquired();
		int initialYear = initialDate.getYear();
		LocalDateTime now = LocalDateTime.now();
		int yearNow = now.getYear();
		return yearNow - initialYear;
	}

	@SuppressWarnings("unchecked")
	public Vehicle searchNationalDB(String personalID, String licensePlate) {
		externalFactory = new Configuration().configure().buildSessionFactory();
		Session session = externalFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customer newCustomer = (Customer) session
					.createQuery("FROM Citizens where personal_id='" + personalID + "'").getSingleResult();
			Vehicle car = (Vehicle) session.createQuery(
					"FROM Vehicles where person_id='" + personalID + "'  AND license_plate='" + licensePlate + "'")
					.getSingleResult();
			List<History> incs = session.createQuery("FROM HistoryInc where person_id='" + personalID + "'")
					.getResultList();
			this.custDAO.addCustomer(newCustomer);
			this.vDAO.addVehicle(car);
			List<History> ourIncs = this.incDAO.listAllIncsPerCustomer(personalID);
			if (ourIncs.isEmpty()) {
				for (History incedent : incs) {
					this.incDAO.addIncedent(incedent);
				}
			} else {
				for (History incedent : incs) {
					this.incDAO.updateIncedent(incedent);
				}
			}
			tx.commit();
			return car;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
