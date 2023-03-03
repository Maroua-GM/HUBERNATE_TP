package fr.doranco.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "sexe")
	private String sexe;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "dateNaissance")
	private Date dateNaissance;

	@Column(name = "qualiteService")
	private String qualiteService;

	/*
	 *
	 */
	@OneToOne(cascade = { CascadeType.REMOVE, CascadeType.ALL })
	@JoinColumn(name = "adresse_id", nullable = false, unique = true)
	private Adresse adresse;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Commande> commandes;

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public User() {
	}

	public User(String nom, String prenom, String sexe, String email, String password, Date dateNaissance,
			String qualiteService) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.qualiteService = qualiteService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getQualiteService() {
		return qualiteService;
	}

	public void setQualiteService(String qualiteService) {
		this.qualiteService = qualiteService;
	}

	@Override
	public String toString() {
		return "User [" + (id != null ? "id=" + id + ", " : "") + (nom != null ? "nom=" + nom + ", " : "")
				+ (prenom != null ? "prenom=" + prenom + ", " : "") + (sexe != null ? "sexe=" + sexe + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (dateNaissance != null ? "dateNaissance=" + dateNaissance + ", " : "")
				+ (qualiteService != null ? "qualiteService=" + qualiteService + ", " : "")
				+ (adresse != null ? "adresse=" + adresse + ", " : "")
				+ (commandes != null ? "Liste des commandes=" + commandes : "") + "]";
	}

}
