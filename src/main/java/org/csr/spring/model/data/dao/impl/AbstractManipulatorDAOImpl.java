package org.csr.spring.model.data.dao.impl;

import java.io.Serializable;

import org.csr.spring.model.data.dao.AbstractManipulatorDAO;

import com.google.common.base.Preconditions;

public abstract class AbstractManipulatorDAOImpl<T extends Serializable> extends AbstractDAOImpl<T>
		implements AbstractManipulatorDAO<T> {

	@SuppressWarnings("unchecked")
	public final T update(final T entity) {
		Preconditions.checkNotNull(entity);
		return (T) getCurrentSession().merge(entity);
	}

	public final void delete(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().delete(entity);
	}

	public final void deleteById(final long entityId) {
		final T entity = findOne(entityId);
		Preconditions.checkState(entity != null);
		delete(entity);
	}

	public final void create(final T entity) {
		Preconditions.checkNotNull(entity);
		getCurrentSession().persist(entity);
	}

}
