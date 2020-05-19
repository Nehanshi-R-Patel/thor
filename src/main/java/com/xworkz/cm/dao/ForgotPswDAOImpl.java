package com.xworkz.cm.dao;

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
public class ForgotPswDAOImpl implements ForgotPswDAO {
	
	private static final Logger logger=Logger.getLogger(ForgotPswDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public ForgotPswDAOImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity fetchEmailId(String mailId) throws DAOException {
		logger.info("Invoking EmailId...");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = sessionFactory.openSession();

			String hqlQry = "from RegisterEntity  where email='" + mailId + "'";

			logger.info("Creating Query");
			Query<RegisterEntity> query = session.createQuery(hqlQry, RegisterEntity.class);

			logger.info("Getting unique result");
			entity = (RegisterEntity) query.uniqueResult();
			System.out.println("Entity: " + entity);
			if (entity != null) {
				logger.info("Based on EmailId Data Found...");
				return entity;
			}
		} catch (HibernateException e) {
			DAOException exception = new DAOException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	public boolean updatePassword(String password, int count, int id) throws DAOException {
		logger.info("Invoking updatePassword...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			logger.info("Transaction Begins");

			session.beginTransaction();
			String hqlQry = " update RegisterEntity re set re.password = '" + password + "' , re.count='" + count
					+ "' where re.id = '" + id + "'";

			logger.info("Creating Query");
			Query<RegisterEntity> query = session.createQuery(hqlQry);

			logger.info("Getting unique result");
			query.executeUpdate();

			logger.info("Query is updated");
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			DAOException exception = new DAOException();
			logger.error(exception.getMessage(), exception);
			throw exception;
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
	}
}
