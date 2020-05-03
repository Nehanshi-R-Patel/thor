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
public class LoginDAOImpl implements LoginDAO {
	
	private static final Logger logger=Logger.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity fetchEmail(String mail) throws DAOException{
		logger.info("Invoking Email...");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = sessionFactory.openSession();

			String hqlQry = "from RegisterEntity  where email='" + mail + "'";

			logger.info("Creating Query");
			Query<RegisterEntity> query = session.createQuery(hqlQry, RegisterEntity.class);

			logger.info("Getting unique result");
			entity = (RegisterEntity) query.uniqueResult();
			System.out.println("Entity: " + entity);
			if (entity != null) {
				logger.info("Data Found...");
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

	public int updateCount(int count, int id) throws DAOException{
		logger.info("Invoking updateCount...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			logger.info("Transaction Begins");

			session.beginTransaction();
			String hqlQry = " update RegisterEntity re set re.count = '" + count + "' where re.id = '" + id + "'";

			logger.info("Creating Query");
			Query query = session.createQuery(hqlQry);

			logger.info("Getting unique result");
			query.executeUpdate();

			logger.info("Query is updated");
			session.getTransaction().commit();
			return 1;
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
