package fr.doranco.hibernate.dao.interfaces;

import java.util.List;
import java.util.Map;

import fr.doranco.hibernate.entity.User;

public interface IUserDAO {

	public void addUser(User user) throws Exception;

	public User getUser(Integer id) throws Exception;

	public void updateUser(User user) throws Exception;

	public void removeUser(Integer id) throws Exception;

	public List<User> getListeUsers() throws Exception;

	public List<User> getListeUsersByNom(String nom) throws Exception;

	public List<User> getListeUsersOfVille(String ville) throws Exception;

	public Map<String, List<User>> getUsersByVille() throws Exception;

}
