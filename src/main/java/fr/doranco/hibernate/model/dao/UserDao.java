package fr.doranco.hibernate.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.dao.interfaces.IUserDAO;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.datasource.HibernateDataSource;
import fr.doranco.hibernate.util.Dates;

public class UserDao implements IUserDAO {

	@Override
	public void addUser(User user) throws Exception {
		Session session = HibernateDataSource.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(user);
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
	public User getUser(Integer id) throws Exception {
		Session session = HibernateDataSource.getSession();
		User user = null;

		try {
			user = (User) session.createQuery("select a from User a where a.id=?1").setParameter(1, id)
					.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateUser(User user) throws Exception {
		Session session = HibernateDataSource.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createQuery(
					"UPDATE User a SET a.nom=?1, a.prenom=?2,a.sexe=?3,a.email=?4,a.password=?5,a.dateNaissance=?6")
					.setParameter(1, user.getNom()).setParameter(2, user.getPrenom()).setParameter(3, user.getSexe())
					.setParameter(4, user.getEmail()).setParameter(5, user.getPassword())
					.setParameter(6, Dates.dateUtilToSql(user.getDateNaissance())).executeUpdate();
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
	public void removeUser(Integer id) throws Exception {
		Session session = HibernateDataSource.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User user = session.get(User.class, id);
			session.remove(user);
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
	public List<User> getListeUsers() throws Exception {
		Session session = HibernateDataSource.getSession();
		List<User> users = null;
		try {
			users = session.createQuery("from User").list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return users;
	}

	@Override
	public List<User> getListeUsersByNom(String nom) throws Exception {
		Session session = HibernateDataSource.getSession();
		List<User> users = null;
		try {
			users = session.createQuery("select u from User u where u.nom=?1").setParameter(1, nom).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return users;
	}

	@Override
	public List<User> getListeUsersOfVille(String ville) throws Exception {

		Session session = HibernateDataSource.getSession();
		List<User> users = null;
		try {
			users = session
					.createQuery(
							"select u from User u where u.adresse in (select a.id from Adresse a where a.ville=?1)")
					.setParameter(1, ville).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return users;
	}

	@Override
	public Map<String, List<User>> getUsersByVille() throws Exception {
		Session session = HibernateDataSource.getSession();
		List<String> villes;
		List<User> users = null;
		Map<String, List<User>> map = new HashMap<String, List<User>>();
		try {
			villes = session.createQuery("select DISTINCT a.ville from Adresse a").list();
			if (!villes.isEmpty()) {

				for (String ville : villes) {
					map.put(ville, getListeUsersOfVille(ville));
				}

			} else {
				throw new Exception("aucune ville a ete retouvé");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return map;
	}

}
