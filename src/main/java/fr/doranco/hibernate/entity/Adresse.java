package fr.doranco.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String numero;
	@Column
	private String rue;
	@Column
	private String ville;
	@Column
	private String codePostal;

	public Adresse() {
	}

	public Adresse(String numero, String rue, String ville, String codePostal) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Adresse [" + (id != null ? "id=" + id + ", " : "") + (numero != null ? "numero=" + numero + ", " : "")
				+ (rue != null ? "rue=" + rue + ", " : "") + (ville != null ? "ville=" + ville + ", " : "")
				+ (codePostal != null ? "codePostal=" + codePostal : "") + "]";
	}

}
