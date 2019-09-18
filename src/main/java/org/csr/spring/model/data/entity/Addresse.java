package org.csr.spring.model.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESSE")
public class Addresse {
	@Id
	@Column(name = "ADDRESSE_ID")
	private Long id;

	@Column(name = "NO_CIVIQUE")
	private Long noCivique;

	@Column(name = "NOM_RUE")
	private String nomRue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLE_ID")
	private DomainVille ville;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNoCivique() {
		return noCivique;
	}

	public void setNoCivique(Long noCivique) {
		this.noCivique = noCivique;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public DomainVille getVille() {
		return ville;
	}

	public void setVille(DomainVille ville) {
		this.ville = ville;
	}

}
