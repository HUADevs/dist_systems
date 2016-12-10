package com.huaDevelopers.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huaDevelopers.data.Entities.Department;

public class DeptDAOImpl implements DepartmentDAO {

	private static final Logger logger = LoggerFactory.getLogger(DeptDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addDept(Department dept) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dept);
		logger.info("New Department has joined the enterprice" + dept.toString());
	}

	@Override
	public void updateDeptInfo(Department dept) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dept);
		logger.info("Department information have been updated" + dept.toString());
	}

	@Override
	public void deleteDept(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Department dept = session.load(Department.class, new Integer(id));
		if (dept != null) {
			session.delete(dept);
			logger.info("Department has been successfully deleted. " + dept.toString());
		} else
			logger.info("Something went wrong!!!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Department> list = session.createQuery("from Department").getResultList();
		return list;
	}

	@Override
	public Department getDeptByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Department  dept = session.load(Department.class, new Integer(id));
		logger.info("Department successfully selected from db. " + dept.toString());
		return dept;
	}

}
