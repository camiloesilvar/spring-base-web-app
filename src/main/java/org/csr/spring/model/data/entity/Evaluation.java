package org.csr.spring.model.data.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "EVALUATION")
@SequenceGenerator(sequenceName = "S_EVALUATION", name = "S_EVALUATION_GEN", allocationSize = 1)
public class Evaluation extends AbstractEntity {

	private static final long serialVersionUID = -1009308470511886794L;

	@Id
	@Column(name = "ID_EVALUATION")
	@GeneratedValue(generator = "S_EVALUATION_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "REFERENCE")
	private Long reference;

	@Column(name = "DATE_CREATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_EVALUATION", referencedColumnName = "ID_EVALUATION", nullable = false, updatable = false)
	@MapKeyColumn(name = "REFERENCE")
	@Fetch(FetchMode.SELECT)
	private Map<Long, Section> sections;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Map<Long, Section> getSections() {
		return sections;
	}

	public void setSections(Map<Long, Section> sections) {
		this.sections = sections;
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", code=" + code + ", reference=" + reference + ", dateCreation=" + dateCreation
				+ ", sections=" + sections + "]";
	}
}
