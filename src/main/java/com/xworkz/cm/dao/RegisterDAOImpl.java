package com.xworkz.cm.dao;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xworkz.cm.entity.RegisterEntity;

@Controller
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDAOImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public void saveRegisterData(RegisterEntity entity) {
		System.out.println("invoking save register....");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Transaction Begins");
			
			session.beginTransaction();
			
			Serializable id=session.save(entity);
			System.out.println("Query saved: "+id);
			
			session.getTransaction().commit();
			if (Objects.nonNull(entity)) {
				System.out.println("Data Stored Successfully...");
			} else {
				System.out.println("Data not Stored Successfully...");
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
	}

	public boolean getUserId(String userId) {
		System.out.println("invoking getUserid");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Creating Query");
			
			String hql = " from RegisterEntity re where re.userId=?";
			Query<RegisterEntity> query = session.createQuery(hql, RegisterEntity.class);
			
			query.setParameter(0, userId);
			System.out.println("Getting unique result");
			RegisterEntity result = query.uniqueResult();
			
			System.out.println("UserId Result :" + result);
			if (result == null)
				return true;
			else
				return false;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
		return false;
	}

	public boolean getEmail(String emailId) {
		System.out.println("invoking getemailId");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println("Creating Query");
			
			String hql = " from RegisterEntity re where re.email=?";
			Query<RegisterEntity> query = session.createQuery(hql, RegisterEntity.class);
			
			query.setParameter(0, emailId);
			
			System.out.println("Getting unique result");
			RegisterEntity result = query.uniqueResult();
			
			System.out.println("Email Result :" + result);
			if (result == null)
				return true;
			else
				return false;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
		return false;
	}
}
