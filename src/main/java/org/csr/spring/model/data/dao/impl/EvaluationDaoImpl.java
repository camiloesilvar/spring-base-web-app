package org.csr.spring.model.data.dao.impl;

import org.csr.spring.model.data.dao.EvaluationDAO;
import org.csr.spring.model.data.entity.Evaluation;
import org.springframework.stereotype.Repository;

@Repository(value = "evaluationDao")
public class EvaluationDaoImpl extends AbstractManipulatorDAOImpl<Evaluation> implements EvaluationDAO {

	public EvaluationDaoImpl() {
		super();
		setClazz(Evaluation.class);
	}
}
