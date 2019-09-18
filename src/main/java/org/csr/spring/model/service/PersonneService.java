package org.csr.spring.model.service;

import java.util.List;

import org.csr.spring.model.data.entity.Personne;

public interface PersonneService {
	List<Personne> obtenirPersonnes();

	List<Personne> obtenirPersonnesParCriteria();

	List<Personne> obtenirPersonnesParDetachedCriteria();
}
