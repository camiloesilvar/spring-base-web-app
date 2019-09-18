package org.csr.spring.model.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.csr.spring.model.data.dao.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAOImpl<T extends Serializable> implements AbstractDAO<T> {

	protected Class<T> clazz;
	private Logger logger = LogManager.getLogger(AbstractDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T findOne(long id) {
		return ((T) getCurrentSession().get(clazz, id));
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		logger.debug(String.format("Classe: %s", clazz.getSimpleName()));
		return getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
