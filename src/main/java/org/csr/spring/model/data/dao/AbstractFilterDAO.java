package org.csr.spring.model.data.dao;

import java.io.Serializable;
import java.util.List;

import org.csr.spring.model.data.filter.BaseFilter;

public interface AbstractFilterDAO<T extends Serializable, F extends BaseFilter> extends AbstractDAO<T> {

	List<T> find(F filter);
}
