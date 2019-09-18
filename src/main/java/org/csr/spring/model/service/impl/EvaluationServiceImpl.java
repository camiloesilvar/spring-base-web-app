package org.csr.spring.model.service.impl;

import org.csr.spring.model.data.dao.EvaluationDAO;
import org.csr.spring.model.data.entity.Evaluation;
import org.csr.spring.model.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Preconditions;

@Service(value = "evaluationService")
@Transactional
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationDAO dao;

	public Evaluation save(Evaluation evaluation) {
		Preconditions.checkNotNull(evaluation);
		return dao.update(evaluation);
	}

	public void delete(Evaluation evaluation) {
		dao.delete(evaluation);
	}

}
