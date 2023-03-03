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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Commande_getCommandes", query = "from Commande")
public class Commande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String numero;
	@Column(nullable = false)
	private Date dateCommande;
	@Column
	private Date dateLivraison;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande", fetch = FetchType.EAGER)
	private List<LigneDeCommande> listeLignesDeCommandes;

	public List<LigneDeCommande> getListeLignesDeCommandes() {
		return listeLignesDeCommandes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commande() {
	}

	public Commande(String numero, Date dateCommande, Date dateLivraison) {
		super();
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	@Override
	public String toString() {
		return "Commande [" + (id != null ? "id=" + id + ", " : "") + (numero != null ? "numero=" + numero + ", " : "")
				+ (dateCommande != null ? "dateCommande=" + dateCommande + ", " : "")
				+ (dateLivraison != null ? "dateLivraison=" + dateLivraison + ", " : "")
				+ (listeLignesDeCommandes != null ? "listeLignesDeCommandes=" + listeLignesDeCommandes : "") + "]";
	}

}
