package org.csr.spring.model.data.dao;

import java.util.List;

import org.csr.spring.model.data.entity.Personne;

public interface PersonneDAO extends AbstractDAO<Personne> {
	List<Personne> findByCriteria();

	List<Personne> findByDetachedCriteria();
}
