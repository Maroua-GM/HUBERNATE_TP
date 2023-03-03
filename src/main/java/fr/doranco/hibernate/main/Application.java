package fr.doranco.hibernate.main;

import java.util.List;
import java.util.Map;

import fr.doranco.hibernate.dao.interfaces.IAdresseDao;
import fr.doranco.hibernate.dao.interfaces.ICommandeDao;
import fr.doranco.hibernate.dao.interfaces.ILigneDeCommandeDao;
import fr.doranco.hibernate.dao.interfaces.IUserDAO;
import fr.doranco.hibernate.entity.User;
import fr.doranco.hibernate.model.dao.AdresseDao;
import fr.doranco.hibernate.model.dao.CommandeDao;
import fr.doranco.hibernate.model.dao.LigneDeCommandeDao;
import fr.doranco.hibernate.model.dao.UserDao;

public class Application {

	public static void main(String[] args) throws Exception {
		IUserDAO userDAO = new UserDao();
		IAdresseDao adresseDao = new AdresseDao();
		ICommandeDao commandeDao = new CommandeDao();
		ILigneDeCommandeDao ligneDeCommandeDao = new LigneDeCommandeDao();

//		User user = new User("gamraoui", "mahfoud", "homme", "mahfoud@gmail.com", "1234",
//				Dates.stringToDate("19/06/1993"), "meduim");
//
//		Adresse adresse = new Adresse("15", "rue", "alger", "234567");
//		user.setAdresse(adresse);
//
//		System.out.println("user avant ajout dans la BDD: " + user);
//
//		userDAO.addUser(user);
//
//		System.out.println("*********************************************");
//		System.out.println("user apres ajout dans la BDD: " + user);
		// userDAO.removeUser(1);
//		Adresse adresse = new Adresse("100", "new rue", "new ville", "new code postal");
//		adresse.setId(5);
//		adresseDao.updateAdresse(adresse);
		// userDAO.getListeUsersByVille("annaba").forEach(System.out::println);
		Map<String, List<User>> map = userDAO.getUsersByVille();
		for (Map.Entry<String, List<User>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<User> val = entry.getValue();
			System.out.println("**************" + key + "********************");
			val.forEach(System.out::println);

		}
//		/**
//		 * ajouter une commande
//		 */
//		Commande commande = new Commande("2", Dates.stringToDate("11/03/2023"), Dates.stringToDate("23/03/2023"));
//		commande.setUser(userDAO.getUser(2));
//		commandeDao.addCommande(commande);
		// System.out.println(userDAO.getUser(2));
		// commandeDao.getCommandesByUtilisateurId(2).forEach(System.out::println);
//		User user = userDAO.getUser(2);
//		LigneDeCommande ligneDeCommande = new LigneDeCommande("sac", 100f, 4);
//		ligneDeCommande.setCommande(user.getCommandes().get(0));
//		ligneDeCommandeDao.addLigneDeCommande(ligneDeCommande);
//		System.out.println(
//				"la liste de tt les utilisateurs avec leurs commandes et chaque commande avec ses lignes de commandes");
//		List<User> liste = userDAO.getListeUsers();
//		for (User user : liste) {
//			System.out.println("Nom: " + user.getNom());
//			System.out.println("Prenom: " + user.getPrenom());
//			System.out.println("Adresse: " + user.getAdresse().getNumero() + " " + user.getAdresse().getRue() + " "
//					+ user.getAdresse().getVille());
//
//			if (!user.getCommandes().isEmpty()) {
//				System.out.println("Commandes: ");
//				for (Commande commande : user.getCommandes()) {
//					System.out
//							.println(" ******************la commande numero : " + commande.getNumero() + " commandé le "
//									+ commande.getDateCommande() + " sera livré le  " + commande.getDateLivraison());
//					if (!commande.getListeLignesDeCommandes().isEmpty()) {
//						System.out.println("*********************************Les lignes de commandes: ");
//						for (LigneDeCommande ligneDeCommande : commande.getListeLignesDeCommandes()) {
//							System.out.println("----------------------------------->" + ligneDeCommande);
//
//						}
//					}
//				}
//			}
//
//		}

	}

}
