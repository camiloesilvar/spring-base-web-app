package org.csr.spring.model.data.dao;

import java.util.List;

public interface AbstractDAO<T> {
	T findOne(final long id);

	List<T> findAll();

}
