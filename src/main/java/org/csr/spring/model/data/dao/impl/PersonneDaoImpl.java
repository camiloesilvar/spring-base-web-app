package org.csr.spring.model.data.dao.impl;

import java.util.List;

import org.csr.spring.model.data.dao.PersonneDAO;
import org.csr.spring.model.data.entity.Addresse;
import org.csr.spring.model.data.entity.Personne;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

@Repository(value = "personneDao")
public class PersonneDaoImpl extends AbstractDAOImpl<Personne> implements PersonneDAO {

	public PersonneDaoImpl() {
		super();
		setClazz(Personne.class);
	}

	@SuppressWarnings("unchecked")
	public List<Personne> findByCriteria() {
		// Fetch de la persona y direcciones.
		// Select con LEFT OUTER JOIN (H3) (H4)
//		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class, "pers")
//				.setFetchMode("addresseFacturation", FetchMode.JOIN)
//				.setFetchMode("addresseCorrespondance", FetchMode.JOIN);

		// Fetch de las entidades en un solo "select". 1 metodo
		// Select con INNER JOIN (H3) (H4)
//		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class, "pers");
//		Criteria addresseFCriteria = perssoneCriteria.createCriteria("addresseFacturation", "addrf");
//		Criteria addresseCCriteria = perssoneCriteria.createCriteria("addresseCorrespondance", "addrc");
//		addresseFCriteria.createCriteria("ville", "vlf");
//		addresseCCriteria.createCriteria("ville", "vlc");

		// Select con LEFT OUTER JOIN (H3) (H4 Deprecated)
//		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class);
//		Criteria addresseFCriteria = perssoneCriteria.createCriteria("addresseFacturation", CriteriaSpecification.LEFT_JOIN);
//		Criteria addresseCCriteria = perssoneCriteria.createCriteria("addresseCorrespondance", CriteriaSpecification.LEFT_JOIN);
//		addresseFCriteria.createCriteria("ville", CriteriaSpecification.LEFT_JOIN);
//		addresseCCriteria.createCriteria("ville", CriteriaSpecification.LEFT_JOIN);

		// Select con LEFT OUTER JOIN (H4)
		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class);
		Criteria addresseFCriteria = perssoneCriteria.createCriteria("addresseFacturation", "addF",
				JoinType.LEFT_OUTER_JOIN);
		Criteria addresseCCriteria = perssoneCriteria.createCriteria("addresseCorrespondance", "addC",
				JoinType.LEFT_OUTER_JOIN);
		addresseFCriteria.createCriteria(addresseFCriteria.getAlias() + ".ville", JoinType.LEFT_OUTER_JOIN);
		addresseCCriteria.createCriteria(addresseCCriteria.getAlias() + ".ville", JoinType.LEFT_OUTER_JOIN);

		// Fetch de las entidades en un solo "select". 2 metodo
		// Select con INNER JOIN (H3) (H4)
//		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class, "pers")
//				.createAlias("addresseFacturation", "addrf")
//				.createAlias("addresseCorrespondance", "addrc")
//				.createAlias("addresseFacturation.ville", "vlf")
//				.createAlias("addresseCorrespondance.ville", "vlc");

		// Fetch de las entidades en un solo "select".
		// Select con LEFT OUTER JOIN (H3)
//		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class, "pers")
//				.createAlias("addresseFacturation", "addrf", CriteriaSpecification.LEFT_JOIN)
//				.createAlias("addresseCorrespondance", "addrc", CriteriaSpecification.LEFT_JOIN)
//				.createAlias("addresseFacturation.ville", "vlf", CriteriaSpecification.LEFT_JOIN)
//				.createAlias("addresseCorrespondance.ville", "vlc", CriteriaSpecification.LEFT_JOIN);

		// Select con LEFT OUTER JOIN (H4)
//		Criteria perssoneCriteria = getCurrentSession().createCriteria(Personne.class, "pers")
//		.createAlias("addresseFacturation", "addrf", JoinType.LEFT_OUTER_JOIN)
//		.createAlias("addresseCorrespondance", "addrc", JoinType.LEFT_OUTER_JOIN)
//		.createAlias("{alias}.ville", "vlf", JoinType.LEFT_OUTER_JOIN)
//		.createAlias("{alias}.ville", "vlc", JoinType.LEFT_OUTER_JOIN);

		return perssoneCriteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Personne> findByDetachedCriteria() {
		DetachedCriteria subQuery = DetachedCriteria.forClass(Addresse.class, "addresseFacturation")
				.setProjection(Projections.property("addresseFacturation.id"));

		Criteria books = getCurrentSession().createCriteria(Personne.class, "personne")
				.setFetchMode("personne.addresseCorrespondance", FetchMode.JOIN)
				.add(Property.forName("personne.addresseFacturation").in(subQuery));
		return books.list();
	}

}
