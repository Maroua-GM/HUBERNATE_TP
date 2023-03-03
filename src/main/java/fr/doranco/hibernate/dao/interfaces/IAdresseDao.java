package fr.doranco.hibernate.dao.interfaces;

import fr.doranco.hibernate.entity.Adresse;

public interface IAdresseDao {

	public Adresse getAdresse(Integer id) throws Exception;

	public void addAdresse(Adresse adresse) throws Exception;

	public void updateAdresse(Adresse adresse) throws Exception;

	public void removeAdresse(Integer id) throws Exception;

}
