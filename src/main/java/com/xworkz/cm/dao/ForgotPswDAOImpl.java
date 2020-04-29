package com.xworkz.cm.dao;

import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xworkz.cm.entity.RegisterEntity;

@Controller
public class ForgotPswDAOImpl implements ForgotPswDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ForgotPswDAOImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity fetchEmailId(String mailId) {
		System.out.println("Invoking EmailId...");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = sessionFactory.openSession();

			String hqlQry = "from RegisterEntity  where email='" + mailId + "'";

			System.out.println("Creating Query");
			Query<RegisterEntity> query = session.createQuery(hqlQry, RegisterEntity.class);

			System.out.println("Getting unique result");
			entity = (RegisterEntity) query.uniqueResult();
			System.out.println("Entity: " + entity);
			if (entity != null) {
				System.out.println("Based on EmailId Data Found...");
				return entity;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	public int updatePassword(String password, int count, int id) {
		System.out.println("Invoking updatePassword...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Transaction Begins");

			session.beginTransaction();
			String hqlQry = " update RegisterEntity re set re.password = '" + password + "' , re.count='" + count
					+ "' where re.id = '" + id + "'";

			System.out.println("Creating Query");
			Query query = session.createQuery(hqlQry);

			System.out.println("Getting unique result");
			query.executeUpdate();

			System.out.println("Query is updated");
			session.getTransaction().commit();
			return 1;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return 0;
	}
}
