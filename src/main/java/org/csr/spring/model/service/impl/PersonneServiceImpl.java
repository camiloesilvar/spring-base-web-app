package org.csr.spring.model.service.impl;

import java.util.List;

import org.csr.spring.model.data.dao.PersonneDAO;
import org.csr.spring.model.data.entity.Personne;
import org.csr.spring.model.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "personneService")
@Transactional
public class PersonneServiceImpl implements PersonneService {
	@Autowired
	private PersonneDAO dao;

	public List<Personne> obtenirPersonnes() {
		return dao.findAll();
	}

	public List<Personne> obtenirPersonnesParCriteria() {
		return dao.findByCriteria();
	}

	public List<Personne> obtenirPersonnesParDetachedCriteria() {
		return dao.findByDetachedCriteria();
	}
}
