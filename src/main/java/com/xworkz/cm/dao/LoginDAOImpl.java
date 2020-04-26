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
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity fetchEmail(String mail) {
		System.out.println("Invoking Email...");
		Session session = null;
		RegisterEntity entity = null;
		try {
			session = sessionFactory.openSession();

			String hqlQry = "from RegisterEntity  where email='" + mail + "'";

			System.out.println("Creating Query");
			Query<RegisterEntity> query = session.createQuery(hqlQry, RegisterEntity.class);

			System.out.println("Getting unique result");
			entity = (RegisterEntity) query.uniqueResult();
			System.out.println("Entity: " + entity);
			if (entity != null) {
				System.out.println("Data Found...");
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

	public int updateCount(int count, int id) {
		System.out.println("Invoking updateCount...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Transaction Begins");

			session.beginTransaction();
			String hqlQry = " update RegisterEntity re set re.count = '" + count + "' where re.id = '" + id + "'";

			System.out.println("Creating Query");
			Query<RegisterEntity> query = session.createQuery(hqlQry, RegisterEntity.class);

			System.out.println("Getting unique result");
			int result = query.executeUpdate();

			System.out.println("Result: " + result);
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
