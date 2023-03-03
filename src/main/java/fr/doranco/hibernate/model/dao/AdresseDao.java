package fr.doranco.hibernate.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.dao.interfaces.IAdresseDao;
import fr.doranco.hibernate.entity.Adresse;
import fr.doranco.hibernate.model.datasource.HibernateDataSource;

public class AdresseDao implements IAdresseDao {

	@Override
	public Adresse getAdresse(Integer id) throws Exception {
		Session session = null;
		Adresse adresse = null;

		try {
			session = HibernateDataSource.getSession();
			adresse = session.get(Adresse.class, id);

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return adresse;
	}

	@Override
	public void addAdresse(Adresse adresse) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateDataSource.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(adresse);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateDataSource.getSession();
			tx = session.beginTransaction();
			if (session.get(Adresse.class, adresse.getId()) != null) {
				session.update(adresse);
			} else {
				throw new Exception("l'adresse n'existe pas");
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void removeAdresse(Integer id) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateDataSource.getSession();
			tx = session.beginTransaction();
			Adresse adresse = session.get(Adresse.class, id);
			session.remove(adresse);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

}
