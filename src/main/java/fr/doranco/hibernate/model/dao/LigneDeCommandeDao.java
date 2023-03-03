package fr.doranco.hibernate.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.hibernate.dao.interfaces.ILigneDeCommandeDao;
import fr.doranco.hibernate.entity.LigneDeCommande;
import fr.doranco.hibernate.model.datasource.HibernateDataSource;

public class LigneDeCommandeDao implements ILigneDeCommandeDao {

	@Override
	public void addLigneDeCommande(LigneDeCommande ligneDeCommande) throws Exception {
		Session session = HibernateDataSource.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(ligneDeCommande.getCommande());
			session.save(ligneDeCommande);
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

}
