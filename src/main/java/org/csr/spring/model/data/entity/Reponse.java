package org.csr.spring.model.data.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "REPONSE")
@SequenceGenerator(sequenceName = "S_REPONSE", name = "S_REPONSE_GEN", allocationSize = 1)
public class Reponse extends AbstractEntity {

	private static final long serialVersionUID = 5511119470116141844L;

	@Id
	@Column(name = "ID_REPONSE")
	@GeneratedValue(generator = "S_REPONSE_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "TXT_REPONSE")
	private String reponse;

	@Column(name = "REFERENCE")
	private Long reference;

	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_REPONSE", referencedColumnName = "ID_REPONSE", nullable = false, updatable = false)
	@MapKeyColumn(name = "REFERENCE")
	@OrderBy(clause = "ID_VALEUR ASC")
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 40)
	private Map<Long, Valeur> valeurs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public Map<Long, Valeur> getValeurs() {
		return valeurs;
	}

	public void setValeurs(Map<Long, Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", reponse=" + reponse + ", reference=" + reference + ", valeurs=" + valeurs + "]";
	}
}
