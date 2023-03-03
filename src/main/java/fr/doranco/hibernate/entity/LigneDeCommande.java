package fr.doranco.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneDeCommande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String titreArticle;
	@Column(nullable = false)
	private Float prixArticle;
	@Column(nullable = false)
	private Integer quantite;

	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;

	public LigneDeCommande() {
	}

	public LigneDeCommande(String titreArticle, Float prixArticle, Integer quantite) {
		super();
		this.titreArticle = titreArticle;
		this.prixArticle = prixArticle;
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public Float getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(Float prixArticle) {
		this.prixArticle = prixArticle;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [" + (id != null ? "id=" + id + ", " : "")
				+ (titreArticle != null ? "titreArticle=" + titreArticle + ", " : "")
				+ (prixArticle != null ? "prixArticle=" + prixArticle + ", " : "")
				+ (quantite != null ? "quantite=" + quantite : "") + "]";
	}

}
