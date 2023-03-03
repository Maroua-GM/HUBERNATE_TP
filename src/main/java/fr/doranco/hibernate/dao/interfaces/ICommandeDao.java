package fr.doranco.hibernate.dao.interfaces;

import java.util.List;

import fr.doranco.hibernate.entity.Commande;

public interface ICommandeDao {

	public Commande getCommande(Integer id) throws Exception;

	public void addCommande(Commande commande) throws Exception;

	public void updateCommande(Commande commande) throws Exception;

	public void removeCommande(Integer id) throws Exception;

	public List<Commande> getCommandes1() throws Exception;// version 1 avec createQuery

	public List<Commande> getCommandes2() throws Exception;// version 2 avec NamedQuery

	public List<Commande> getCommandes3() throws Exception;// version 3 avec createNativeQuery

	public List<Commande> getCommandesByUtilisateurId(Integer userId) throws Exception;

}
