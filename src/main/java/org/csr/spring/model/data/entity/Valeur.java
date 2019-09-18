package org.csr.spring.model.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VALEUR")
@SequenceGenerator(sequenceName = "S_VALEUR", name = "S_VALEUR_GEN", allocationSize = 1)
public class Valeur extends AbstractEntity {

	private static final long serialVersionUID = 3789710983045967390L;

	@Id
	@Column(name = "ID_VALEUR")
	@GeneratedValue(generator = "S_VALEUR_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "TXT_VALEUR")
	private String valeur;

	@Column(name = "REFERENCE")
	private Long reference;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REPONSE", insertable = false, updatable = false)
	private Reponse reponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Valeur [id=" + id + ", valeur=" + valeur + ", reference=" + reference + ", reponse=" + reponse + "]";
	}
}
