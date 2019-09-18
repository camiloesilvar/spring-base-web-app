package org.csr.spring.model.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONNE")
public class Personne implements Serializable {

	private static final long serialVersionUID = -7036092333671286868L;

	@Id
	@Column(name = "PERSONNE_ID")
	private Long id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESSE_ID_FACT", referencedColumnName = "ADDRESSE_ID")
	private Addresse addresseFacturation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESSE_ID_RESI", referencedColumnName = "ADDRESSE_ID")
	private Addresse addresseCorrespondance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Addresse getAddresseFacturation() {
		return addresseFacturation;
	}

	public void setAddresseFacturation(Addresse addresseFacturation) {
		this.addresseFacturation = addresseFacturation;
	}

	public Addresse getAddresseCorrespondance() {
		return addresseCorrespondance;
	}

	public void setAddresseCorrespondance(Addresse addresseCorrespondance) {
		this.addresseCorrespondance = addresseCorrespondance;
	}

}
