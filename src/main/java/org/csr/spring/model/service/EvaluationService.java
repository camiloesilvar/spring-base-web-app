package org.csr.spring.model.service;

import org.csr.spring.model.data.entity.Evaluation;

public interface EvaluationService {
	Evaluation save(Evaluation evaluation);

	void delete(Evaluation evaluation);
}
