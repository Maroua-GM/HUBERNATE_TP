package fr.doranco.hibernate.model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.dao.interfaces.ICommandeDao;
import fr.doranco.hibernate.entity.Commande;
import fr.doranco.hibernate.model.datasource.HibernateDataSource;

public class CommandeDao implements ICommandeDao {

	@Override
	public Commande getCommande(Integer id) throws Exception {
		Session session = null;
		Commande commande = null;
		try {
			session = HibernateDataSource.getSession();
			commande = session.get(Commande.class, id);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commande;
	}

	@Override
	public void addCommande(Commande commande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateDataSource.getSession();
			tx = session.beginTransaction();
			session.save(commande.getUser());
			session.save(commande);
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
	public void updateCommande(Commande commande) throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			HibernateDataSource.getSession();
			tx = session.beginTransaction();
			if (session.get(Commande.class, commande.getId()) != null) {
				session.update(commande);
			} else {
				throw new Exception("la commande n'existe pas");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
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
	public void removeCommande(Integer id) throws Exception {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibernateDataSource.getSession();
			tx = session.beginTransaction();
			Commande commande = session.get(Commande.class, id);
			if (commande != null) {
				session.remove(commande);
			} else {
				throw new Exception("la commande n'existe pas dans la base de donnees");
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
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
	public List<Commande> getCommandes1() throws Exception {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateDataSource.getSession();
			commandes = session.createQuery("from Commande").list();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;

	}

	@Override
	public List<Commande> getCommandes2() throws Exception {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateDataSource.getSession();
			commandes = session.createNamedQuery("Commande_getCommandes", Commande.class).getResultList();

			if (commandes.isEmpty()) {
				throw new Exception("pas de commandes");
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;
	}

	@Override
	public List<Commande> getCommandes3() throws Exception {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateDataSource.getSession();
			// recuperer toutes les lignes
			// commandes = session.createNativeQuery("SELECT * FROM Commande",
			// Commande.class).getResultList();
			// recuprer que quelques colonnes de la table commande
			String requete = "select numero,dateCommande from commande";
			List<Object[]> commandes2 = session.createNativeQuery(requete).getResultList();

			for (Object[] objects : commandes2) {
				Commande commande = new Commande();
				for (int i = 0; i < objects.length; i++) {
					commande.setNumero((String) objects[0]);
					commande.setDateCommande((Date) objects[1]);
					commandes.add(commande);
				}
			}

			if (commandes.isEmpty()) {
				throw new Exception("pas de commandes");
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;
	}

	@Override
	public List<Commande> getCommandesByUtilisateurId(Integer userId) throws Exception {
		Session session = null;
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			session = HibernateDataSource.getSession();
			commandes = session.createQuery("select c from Commande c where c.user.id=:id").setParameter("id", userId)
					.getResultList();
			if (commandes.isEmpty()) {
				throw new Exception("pas de commandes");
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return commandes;
	}

}
