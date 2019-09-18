package org.csr.spring.model.data.dao;

import java.io.Serializable;

public interface AbstractManipulatorDAO<T extends Serializable> extends AbstractDAO<T> {

	/**
	 * Hibernate (persist)
	 * 
	 * @param entity la entidad a guardar
	 */
	void create(final T entity);

	/**
	 * Hibernate (merge)
	 * 
	 * @param entity la entidad a guardar
	 * @return la entidad con los cambios.
	 */
	T update(final T entity);

	/**
	 * Hibernate (delete)
	 * 
	 * @param entity la entidad a suprimir
	 */
	void delete(final T entity);

	/**
	 * Hibernate (get) Hibernate (delete)
	 * 
	 * @param entity la entidad a suprimir
	 */
	void deleteById(final long entityId);
}
