package org.csr.spring.model.data.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.csr.spring.model.data.dao.AbstractFilterDAO;
import org.csr.spring.model.data.filter.BaseFilter;
import org.hibernate.Criteria;

public abstract class AbstractFilterDAOImpl<T extends Serializable, F extends BaseFilter> extends AbstractDAOImpl<T>
		implements AbstractFilterDAO<T, F> {

	private Logger logger = LogManager.getLogger(AbstractDAOImpl.class);

	@SuppressWarnings("unchecked")
	public List<T> find(F filter) {
		logger.debug(
				String.format("Classe %s avec filtre: %s", clazz.getSimpleName(), filter.getClass().getSimpleName()));

		return buildCriteriaFromFilter(filter).list();
	}

	private Criteria buildCriteriaFromFilter(F filter) {
		Field[] fields = filter.getClass().getDeclaredFields();

		return getCurrentSession().createCriteria(clazz);
	}
}
