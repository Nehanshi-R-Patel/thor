package com.xworkz.cm.dao;

import java.io.Serializable;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xworkz.cm.entity.RegisterEntity;
import com.xworkz.cm.exception.DAOException;

@Controller
public class RegisterDAOImpl implements RegisterDAO {

	private static final Logger logger = Logger.getLogger(RegisterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDAOImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public void saveRegisterData(RegisterEntity entity) throws DAOException {
		logger.info("invoking save register....");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			logger.info("Transaction Begins");

			session.beginTransaction();

			Serializable id = session.save(entity);
			logger.info("Query saved: " + id);

			session.getTransaction().commit();
			if (Objects.nonNull(entity)) {
				logger.info("Data Stored Successfully...");
			} else {
				logger.info("Data not Stored Successfully...");
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			DAOException exception = new DAOException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
	}

	public boolean getUserId(String userId) throws DAOException {
		logger.info("invoking getUserid");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			logger.info("Creating Query");

			String hql = " from RegisterEntity re where re.userId=?";
			Query<RegisterEntity> query = session.createQuery(hql, RegisterEntity.class);

			query.setParameter(0, userId);
			logger.info("Getting unique result");
			RegisterEntity result = query.uniqueResult();

			logger.info("UserId Result :" + result);
			if (result == null)
				return true;
			else
				return false;
		} catch (HibernateException e) {
			DAOException exception = new DAOException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
	}

	public boolean getEmail(String emailId) throws DAOException {
		logger.info("invoking getemailId");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			logger.info("Creating Query");

			String hql = " from RegisterEntity re where re.email=?";
			Query<RegisterEntity> query = session.createQuery(hql, RegisterEntity.class);

			query.setParameter(0, emailId);

			logger.info("Getting unique result");
			RegisterEntity result = query.uniqueResult();

			logger.info("Email Result :" + result);
			if (result == null)
				return true;
			else
				return false;
		} catch (HibernateException e) {
			DAOException exception = new DAOException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
	}
}
