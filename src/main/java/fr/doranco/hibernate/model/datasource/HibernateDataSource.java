package fr.doranco.hibernate.model.datasource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateDataSource {

	private static HibernateDataSource instance;
	private static SessionFactory sessionFactory;
	private static Session session;

	public HibernateDataSource() throws HibernateException {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	}

	public static Session getSession() throws HibernateException {
		if (instance == null) {
			instance = new HibernateDataSource();
		}
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
