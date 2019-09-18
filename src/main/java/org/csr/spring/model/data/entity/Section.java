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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "SECTION")
@SequenceGenerator(sequenceName = "S_SECTION", name = "S_SECTION_GEN", allocationSize = 1)
public class Section extends AbstractEntity {

	private static final long serialVersionUID = 438662404088895717L;

	@Id
	@Column(name = "ID_SECTION")
	@GeneratedValue(generator = "S_SECTION_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "ID_EVALUATION", insertable = false, updatable = false)
	private Long idEvaluation;

	@Column(name = "TITRE")
	private String titre;

	@Column(name = "REFERENCE")
	private Long reference;

	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_SECTION", referencedColumnName = "ID_SECTION", nullable = false, updatable = false)
	@MapKeyColumn(name = "REFERENCE")
	@Fetch(FetchMode.SELECT)
	private Map<Long, Reponse> reponses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(Long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public Map<Long, Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(Map<Long, Reponse> reponses) {
		this.reponses = reponses;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", idEvaluation=" + idEvaluation + ", titre=" + titre + ", reference=" + reference
				+ ", reponses=" + reponses + "]";
	}
}
